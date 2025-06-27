package com.murari.test.lambdas;

import com.murari.corejava.lambdas.Human;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// @SpringBootTest
// @SpringJUnitConfig
public class CompareExampleTest {

  // 1. Basic Sort Without Lambdas
  @Test
  public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList();
    humans.add(new Human("Sarah", 10));
    humans.add(new Human("Jack", 12));

    Collections.sort(
        humans,
        new Comparator<Human>() {
          @Override
          public int compare(Human h1, Human h2) {
            return h1.getName().compareTo(h2.getName());
          }
        });

    // Use assertEquals to compare the first element with the expected Human object
    Assertions.assertEquals(new Human("Jack", 12), humans.get(0));
  }

  // 2. Basic Sort With Lambda Support
  @Test
  public void whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = new ArrayList<>();
    humans.add(new Human("Sarah", 10));
    humans.add(new Human("Jack", 12));

    humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
    Assertions.assertEquals(new Human("Jack", 12), humans.get(0));
  }

  // 3. Basic Sorting With No Type Definitions
  @Test
  public void givenLambdaShortForm_whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = new ArrayList<>();
    humans.add(new Human("Sarah", 10));
    humans.add(new Human("Jack", 12));

    humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
    Assertions.assertEquals(new Human("Jack", 12), humans.get(0));
  }

  // 4. Sort Using Reference to Static Method
  @Test
  public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {

    List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

    humans.sort(Human::compareByNameThenAge);
    Assertions.assertEquals(new Human("Jack", 12), humans.get(0));
  }

  // 5. Sort Extracted Comparators
  @Test
  public void givenInstanceMethod_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
    Collections.sort(humans, Comparator.comparing(Human::getName));
    Assertions.assertEquals(new Human("Jack", 12), humans.get(0));
  }

  // 6. Reverse Sort
  @Test
  public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

    Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());

    humans.sort(comparator.reversed());

    Assertions.assertEquals(new Human("Jack", 12), humans.get(1));
  }

  // 7. Sort With Multiple Conditions
  @Test
  public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
    List<Human> humans =
        Lists.newArrayList(new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
    humans.sort(
        (lhs, rhs) -> {
          if (lhs.getName().equals(rhs.getName())) {
            return Integer.compare(lhs.getAge(), rhs.getAge());
          } else {
            return lhs.getName().compareTo(rhs.getName());
          }
        });
    Assertions.assertEquals(humans.get(0), new Human("Sarah", 10));
  }

  // 8. Sort With Multiple Conditions – Composition
  @Test
  public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
    List<Human> humans =
        Lists.newArrayList(new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
    humans.sort(
        (lhs, rhs) -> {
          if (lhs.getName().equals(rhs.getName())) {
            return Integer.compare(lhs.getAge(), rhs.getAge());
          } else {
            return lhs.getName().compareTo(rhs.getName());
          }
        });

    humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));

    Assertions.assertEquals(humans.get(0), new Human("Sarah", 10));
  }

  // 9. Sorting a List With Stream.sorted()
  @Test
  public void givenStreamNaturalOrdering_whenSortingList_thenCorrectlySorted() {
    List<String> letters = Lists.newArrayList("B", "A", "C");

    List<String> sortedLetters = letters.stream().sorted().collect(Collectors.toList());
    Assertions.assertEquals("A", sortedLetters.get(0));
  }

  // 10. Sorting a List With Stream.sorted() with custom Comparator
  @Test
  public void givenStreamCustomOrdering_whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 12), new Human("Zack", 12));

    Comparator<Human> humanComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());

    List<Human> sortedHumans = humans.stream().sorted(humanComparator).collect(Collectors.toList());
    Assertions.assertEquals(sortedHumans.get(0), new Human("Sarah", 12));
  }

  // 11. Sorting a List With Stream.sorted() with Comparator InstanceMethod
  @Test
  public void givenStreamComparatorOrdering_whenSortingEntitiesByName_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 12), new Human("Zack", 12));

    Comparator<Human> humanComparator = Comparator.comparing(Human::getName);

    List<Human> sortedHumans = humans.stream().sorted(humanComparator).collect(Collectors.toList());
    Assertions.assertEquals(sortedHumans.get(0), new Human("Sarah", 12));
  }

  // 12. Sorting a List in Reverse With Stream.sorted()
  @Test
  public final void
      givenStreamNaturalOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
    List<String> letters = Lists.newArrayList("B", "A", "C");

    List<String> reverseSortedLetters =
        letters.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    Assertions.assertEquals(reverseSortedLetters.get(0), "C");
  }

  @Test
  public final void
      givenStreamCustomOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
    Comparator<Human> reverseNameComparator = (h1, h2) -> h2.getName().compareTo(h1.getName());

    List<Human> reverseSortedHumans =
        humans.stream().sorted(reverseNameComparator).collect(Collectors.toList());

    Assertions.assertEquals(reverseSortedHumans.get(0), new Human("Sarah", 10));
  }

  @Test
  public final void
      givenStreamComparatorOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
    List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));

    List<Human> reverseSortedHumans =
        humans.stream()
            .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
            .collect(Collectors.toList());

    Assertions.assertEquals(reverseSortedHumans.get(0), new Human("Sarah", 10));
  }

  // 13. Null Values
  @Test()
  public void givenANullElement_whenSortingEntitiesByName_thenThrowsNPE() {
    List<Human> humans = Lists.newArrayList(null, new Human("Jack", 12));

    Assertions.assertThrows(
        NullPointerException.class,
        () -> {
          humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        });
  }

  // 14. handle null values manually in Comparator implementation
  @Test
  public void givenANullElement_whenSortingEntitiesByNameManually_thenMovesTheNullToLast() {
    List<Human> humans = Lists.newArrayList(null, new Human("Jack", 12), null);

    humans.sort(
        (h1, h2) -> {
          if (h1 == null) {
            return h2 == null ? 0 : 1;
          } else if (h2 == null) {
            return -1;
          }
          return h1.getName().compareTo(h2.getName());
        });

    Assertions.assertNotNull(humans.get(0));
    Assertions.assertNull(humans.get(1));
    Assertions.assertNull(humans.get(2));
  }

  // 15.  handle null values using  Comparator.nullsLast()
  @Test
  public void givenANullElement_whenSortingEntitiesByName_thenMovesTheNullToLast() {
    List<Human> humans = Lists.newArrayList(null, new Human("Jack", 12), null);

    humans.sort(Comparator.nullsLast(Comparator.comparing(Human::getName)));

    Assertions.assertNotNull(humans.get(0));
    Assertions.assertNull(humans.get(1));
    Assertions.assertNull(humans.get(2));
  }
}
