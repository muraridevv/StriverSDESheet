package com.murari.striverheet.arrayspart3;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int majority = nums[0]; // Assume the first element as the majority
        int count = 1; // Initialize count for the majority element

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != majority) { // If the current element is different from the majority
                count--; // Decrease the count
                if (count == 0) { // If count becomes 0, change majority
                    majority = nums[i]; // Set new majority candidate
                    count = 1; // Reset count
                }
            } else {
                count++; // If element matches the current majority, increase the count
            }
        }
        return majority; // Return the majority element
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();

        // Example input array
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 2, 4};

        // Call the majorityElement method and store the result
        int result = obj.majorityElement(nums);

        // Print the majority element
        System.out.println("The majority element is: " + result);
    }
}
