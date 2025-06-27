package com.murari.test.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StreamPractice2 {
  /**
   * Tests the Fibonacci sequence generation using Java Streams. Verifies the first 10 numbers of
   * the Fibonacci sequence.
   */
  @Test
  public void testFibonacciSequence() {
    List<Long> fibonacci =
        Stream.iterate(new long[] {0, 1}, f -> new long[] {f[1], f[0] + f[1]})
            .map(f -> f[0])
            .limit(10)
            .collect(Collectors.toList());

    List<Long> expected = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L);
    Assertions.assertEquals(expected, fibonacci, "Fibonacci sequence mismatch!");
  }

  /**
   * Tests the calculation of the median value in a list of integers. Ensures the median is computed
   * correctly for an odd-sized list.
   */
  @Test
  public void testMedianOfIntegers() {
    List<Integer> numbers = Arrays.asList(5, 2, 1, 3, 4);
    double median =
        numbers.stream()
            .sorted()
            .skip((numbers.size() - 1) / 2)
            .limit(2 - numbers.size() % 2)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(-1);

    Assertions.assertEquals(3.0, median, "Median calculation is incorrect!");
  }

  /**
   * Finds the longest common prefix from a list of strings using Java Streams. Ensures the prefix
   * is calculated correctly for a given list.
   */
  @Test
  public void testLongestCommonPrefix() {
    List<String> strings = Arrays.asList("flower", "flow", "flight");
    String longestCommonPrefix =
        strings.stream()
            .reduce(
                (s1, s2) -> {
                  int length = Math.min(s1.length(), s2.length());
                  int i = 0;
                  while (i < length && s1.charAt(i) == s2.charAt(i)) {
                    i++;
                  }
                  return s1.substring(0, i);
                })
            .orElse("");

    Assertions.assertEquals("fl", longestCommonPrefix, "Longest common prefix mismatch!");
  }

  /**
   * Tests the calculation of the maximum product of two integers in an array. Verifies the product
   * for a given array of integers.
   */
  @Test
  public void testMaximumProductOfTwoIntegers() {
    int[] array = {1, 4, 3, 6, 2, 7, 8};
    int maxProduct =
        Arrays.stream(array)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .reduce(1, (a, b) -> a * b);

    Assertions.assertEquals(56, maxProduct, "Maximum product calculation is incorrect!");
  }

  /**
   * Groups a list of words into anagrams using Java Streams. Validates the grouping result for a
   * given list of strings.
   */
  @Test
  public void testAnagrams() {
    List<String> words = Arrays.asList("listen", "silent", "hello", "world", "night", "thing");
    Map<String, List<String>> anagrams =
        words.stream()
            .collect(
                Collectors.groupingBy(
                    word -> {
                      char[] chars = word.toCharArray();
                      Arrays.sort(chars);
                      return new String(chars);
                    }));

    Map<String, List<String>> expected =
        Map.of(
            "eilnst", Arrays.asList("listen", "silent"),
            "ehllo", Collections.singletonList("hello"),
            "dlorw", Collections.singletonList("world"),
            "ghint", Arrays.asList("night", "thing"));

    Assertions.assertEquals(expected, anagrams, "Anagram grouping mismatch!");
  }
}
