package com.murari.striverheet.linkedlistandarrays;

public class RemoveDuplicatesFromSortedArrays {

  public static int removeDuplicates(int[] nums) {
    // Example array: [0,0,1,1,1,2,2,3,3,4]
    // Initialize pointer i to track the position where unique elements will be stored
    int i = 1;

    // Iterate through the array starting from the second element
    for (int j = 1; j < nums.length; j++) {
      // Check if the current element is different from the previous one
      if (nums[j] != nums[j - 1]) {
        // If the current element is different, update the array at position j
        // with the current unique element and move j to the next position
        nums[i] = nums[j];
        i++;
      }
    }

    // Return the length of the updated array with duplicates removed
    return i;
  }

  public static void main(String[] args) {
    // Example array with duplicates
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    // Call the removeDuplicates method to remove duplicates from the array
    int length = removeDuplicates(nums);

    // Print the updated array with duplicates removed
    System.out.print("Updated array with duplicates removed: [");
    for (int i = 0; i < length; i++) {
      System.out.print(nums[i]);
      if (i < length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}
