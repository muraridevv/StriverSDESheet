package com.murari.test.streams;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Java8StreamApi {

  private long counter;

  private List<Product> productList;

  @BeforeAll
  public void init() {
    productList =
        Arrays.asList(
            new Product(23, "potatoes"),
            new Product(14, "orange"),
            new Product(13, "lemon"),
            new Product(23, "bread"),
            new Product(13, "sugar"));
  }

  @Test
  public void checkPipeline_whenStreamOneElementShorter_thenCorrect() {
    List<String> list = Arrays.asList("abc1", "abc2", "abc3");
    long size = list.stream().skip(1).map(element -> element.substring(0, 3)).count();
    Assertions.assertEquals(list.size() - 1, size);
  }

  @Test
  public void checkOrder_whenChangeQuantityOfMethodCalls_thenCorrect() {
    List<String> list = Arrays.asList("abc1", "abc2", "abc3");

    counter = 0;
    List<String> listStream1 =
        list.stream()
            .skip(2)
            .map(
                element -> {
                  counter++;
                  return element.substring(0, 3);
                })
            .toList();
    Assertions.assertEquals(1, counter);

    counter = 0;
    List<String> listStream2 =
        list.stream()
            .map(
                element -> {
                  counter++;
                  return element.substring(0, 3);
                })
            .skip(2)
            .toList();
    Assertions.assertEquals(3, counter);
  }

  @Test
  public void createEmptyStream_whenEmpty_thenCorrect() {
    Stream<String> streamEmpty = Stream.empty();
    Assertions.assertEquals(0, streamEmpty.count());

    List<String> names = Collections.emptyList();
    Stream<String> productStream = Product.streamOf(names);
    Assertions.assertEquals(0, productStream.count());
  }

  @Test
  public void createStream_whenCreated_thenCorrect() {
    Collection<String> collection = Arrays.asList("a", "b", "c");
    Stream<String> streamOfCollection = collection.stream();
    Assertions.assertEquals(3, streamOfCollection.count());

    Stream<String> streamOfArray = Stream.of("a", "b", "c");
    Assertions.assertEquals(3, streamOfArray.count());

    String[] arr = new String[] {"a", "b", "c"};
    Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
    Assertions.assertEquals(2, streamOfArrayPart.count());

    IntStream intStream = IntStream.range(1, 4);
    LongStream longStream = LongStream.rangeClosed(1, 4);
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(4);
    Assertions.assertEquals(3, intStream.count());
    Assertions.assertEquals(4, longStream.count());
    Assertions.assertEquals(4, doubleStream.count());

    IntStream streamOfChars = "abc".chars();
    Assertions.assertEquals(3, streamOfChars.count());

    Stream<String> streamOfString = Pattern.compile(",").splitAsStream("a,b,c");
    Assertions.assertEquals("a", streamOfString.findFirst().get());

    Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
    Assertions.assertEquals(3, streamBuilder.count());

    Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
    Assertions.assertEquals(10, streamGenerated.count());

    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 1).limit(20);
    Assertions.assertTrue(40 <= streamIterated.findAny().get());
  }

  @Test
  public void runStreamPipeline_whenOrderIsRight_thenCorrect() {
    List<String> list = Arrays.asList("abc1", "abc2", "abc3");
    Optional<String> optionalStream =
        list.stream()
            .filter(
                element -> {
                  System.out.println("filter() was called");
                  return element.contains("2");
                })
            .map(
                element -> {
                  System.out.println("map() was called");
                  return element.toUpperCase();
                })
            .findFirst();
  }

  @Test
  public void reduce_whenExpected_thenCorrect() {
    OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
    Assertions.assertEquals(6, reduced.getAsInt());

    int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
    Assertions.assertEquals(16, reducedTwoParams);

    int reducedThreeParams =
        Stream.of(1, 2, 3)
            .reduce(
                10,
                (a, b) -> a + b,
                (a, b) -> {
                  System.out.println("Combiner was called");
                  return a + b;
                });
    Assertions.assertEquals(16, reducedThreeParams);

    int reduceThreeParamsParallel =
        Arrays.asList(1, 2, 3).parallelStream()
            .reduce(
                10,
                (a, b) -> a + b,
                (a, b) -> {
                  System.out.println("combiner was called");
                  return a + b;
                });
    Assertions.assertEquals(36, reduceThreeParamsParallel);
  }

  @Test
  public void collecting_whenAsExpected_thenCorrect() {
    List<String> collectorCollection = productList.stream().map(Product::getName).toList();
    Assertions.assertTrue(collectorCollection instanceof List<String>);
    Assertions.assertEquals(5, collectorCollection.size());

    String listToString =
        productList.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
    Assertions.assertTrue(
        listToString.contains(",") && listToString.contains("[") && listToString.contains("]"));

    double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));

    Assertions.assertEquals(17.2, averagePrice);

    int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
    Assertions.assertEquals(86, summingPrice);

    IntSummaryStatistics statistics =
        productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
    Assertions.assertEquals(23, statistics.getMax());

    Map<Integer, List<Product>> collectorMapOfList =
        productList.stream().collect(Collectors.groupingBy(Product::getPrice));
    Assertions.assertEquals(3, collectorMapOfList.size());

    Map<Boolean, List<Product>> mapPartitioned =
        productList.stream().collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
    Assertions.assertEquals(2, mapPartitioned.keySet().size());
  }

  @Test
  public void collect_whenThrows_thenCorrect() {
    Set<Product> unModifiedSet =
        productList.stream()
            .collect(
                Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    Assertions.assertThrows(
        UnsupportedOperationException.class,
        () -> {
          unModifiedSet.add(new Product(4, "Tea"));
        });
  }

  @Test
  public void customCollector_whenResultContainsAllElementsFromSource_thenCorrect() {
    Collector<Product, ?, LinkedList<Product>> toLinkedList =
        Collector.of(
            LinkedList::new,
            LinkedList::add,
            (first, second) -> {
              first.addAll(second);
              return first;
            });

    LinkedList<Product> linkedListOfProduct = productList.stream().collect(toLinkedList);
    Assertions.assertTrue(linkedListOfProduct.containsAll(productList));
  }

  @Test
  public void parallelStream_whenWorks_thenCorrect() {
    Stream<Product> streamOfCollection = productList.parallelStream();
    boolean isParallel = streamOfCollection.isParallel();
    boolean haveBigPrice =
        streamOfCollection.map(product -> product.getPrice() * 12).anyMatch(price -> price > 200);
    Assertions.assertTrue(isParallel && haveBigPrice);
  }

  @Test
  public void parallel_whenIsParallel_thenCorrect() {
    IntStream intStream = IntStream.range(1, 1000).parallel().map(element -> element * 34);
    boolean isParallel = intStream.isParallel();
    Assertions.assertTrue(isParallel);
  }

  @Test
  public void parallel_whenIsSequential_thenCorrect() {
    IntStream intStreamParallel = IntStream.range(1, 1000).parallel().map(element -> element * 34);
    IntStream intStreamSequential = intStreamParallel.sequential();
    boolean isParallel = intStreamSequential.isParallel();
    Assertions.assertFalse(isParallel);
  }
}
