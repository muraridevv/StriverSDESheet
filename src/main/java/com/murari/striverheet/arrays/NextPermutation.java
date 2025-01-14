package com.murari.striverheet.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutationUsingWhile(int[] nums) {
        if(nums==null || nums.length<=1) return;
        int i=nums.length-2;
        // traverse from backwards till we find nums[i] < nums[i+1]
        while (i>=0 && nums[i]>=nums[i+1]) i--;
        //find the just greater element than at index 1
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i; // Found the pivot
                break;
            }
        }

        if (pivot != -1) {
            // Step 2: Find the smallest element larger than nums[pivot] to the right of pivot
            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    // Swap the two elements
                    swap(nums, pivot, i);
                    break;
                }
            }
        }

        // Step 3: Reverse the elements to the right of the pivot (or the whole array if no pivot)
        reverse(nums, pivot + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println("Next permutation: " + Arrays.toString(nums1)); // Output: [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println("Next permutation: " + Arrays.toString(nums2)); // Output: [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println("Next permutation: " + Arrays.toString(nums3)); // Output: [1, 5, 1]
    }
}


