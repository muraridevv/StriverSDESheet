package com.murari.striverheet.linkedlistandarrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> triplets = findTriplets(nums);

        // Printing the triplets
        System.out.println("Triplets with sum 0:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> findTriplets(int[] nums) {
        Set<List<Integer>> tripletSet = new HashSet<>();
        int n = nums.length;

        // Sort the array to handle duplicates efficiently
        Arrays.sort(nums);

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                // Calculate the third element
                int third = -(nums[i] + nums[j]);

                // Find the element in hashSet
                if (hashSet.contains(third)) {
                    // Found a triplet with sum 0
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp); // Sort the triplet to handle duplicates
                    tripletSet.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }

        // Convert set to list and return
        return new ArrayList<>(tripletSet);
    }
}

/*
Explanation:
This method finds all unique triplets in the array nums such that the sum of each triplet is zero.

Algorithm:
1. Sort the array nums.
2. Initialize a hash set to store unique triplets.
3. Iterate through each element i in nums.
4. Use a nested loop to iterate through each element j after i in nums.
5. Calculate the third element as -(nums[i] + nums[j]).
6. Check if the third element exists in a hash set. If yes, add the triplet to the result set.
7. Add each element to a hash set to efficiently check for the third element in subsequent iterations.
8. Convert the set of triplets to a list and return it.

Example:
Suppose nums = [-1, 0, 1, 2, -1, -4].

Sorted nums = [-4, -1, -1, 0, 1, 2].

Possible triplets:
(-1, -1, 2)
(-1, 0, 1)
*/