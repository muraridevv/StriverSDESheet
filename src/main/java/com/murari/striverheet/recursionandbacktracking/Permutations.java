package com.murari.striverheet.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public void backtrack(List<List<Integer>> resultSet, List<Integer> currentSet, int[] nums) {

    // If we match the length, then its permutation
    if (currentSet.size() == nums.length) {
      resultSet.add(new ArrayList<>(currentSet));
      return;
    }

    for (Integer number : nums) {
      // skip if we get the same element
      if (currentSet.contains(number)) {
        continue;
      }

      // Add the element
      currentSet.add(number);

      // Go back and try other element
      backtrack(resultSet, currentSet, nums);

      // remove the element
      currentSet.remove(currentSet.size() - 1);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> resultSet = new ArrayList<>();
    backtrack(resultSet, new ArrayList<>(), nums);
    return resultSet;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3}; // Example input array
    Permutations solution = new Permutations();
    List<List<Integer>> permutations = solution.permute(nums);
    System.out.println("Permutations:");
    for (List<Integer> permutation : permutations) {
      System.out.println(permutation);
    }
  }
}
