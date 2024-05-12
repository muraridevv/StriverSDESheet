package com.murari.striverheet.dynamicprogramming;

public class MaxProductSubarray {

    public int maxProductBruteForce(int[] nums) {
        int result= Integer.MIN_VALUE;
        int n= nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int product= 1;
                for(int k=i; k<=j; k++){
                    product*= nums[k];
                }
                result= Math.max(product, result);
            }
        }
        return result;
    }

    public int maxProductBetter(int[] nums) {
        int result= Integer.MIN_VALUE;
        int n= nums.length;
        for(int i=0; i<n; i++){
            int product =1;
            for(int j=i; j<n; j++){
                product*= nums[j];
                result= Math.max(product, result);
            }

        }
        return result;
    }

    public int maxProduct(int[] nums) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0) {
            return 0; // If so, return 0 as there's no valid subarray
        }

        // Initialize variables to track maximum product, minimum product, and result
        int maxProd = nums[0]; // Initialize max product so far with the first element
        int minProd = nums[0]; // Initialize min product so far with the first element
        int result = nums[0];  // Initialize result with the first element

        // Iterate through the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            // Store the current value of maxProd in a temporary variable
            int temp = maxProd;

            // Update maxProd to be the maximum among three possibilities:
            // 1. Previous maxProd multiplied by the current element
            // 2. Previous minProd multiplied by the current element
            // 3. Just the current element
            maxProd = Math.max(Math.max(maxProd * nums[i], minProd * nums[i]), nums[i]);

            // Update minProd to be the minimum among three possibilities:
            // 1. Previous temporary maxProd multiplied by the current element
            // 2. Previous minProd multiplied by the current element
            // 3. Just the current element
            minProd = Math.min(Math.min(temp * nums[i], minProd * nums[i]), nums[i]);

            // Update result to be the maximum among the current result and the updated maxProd
            result = Math.max(result, maxProd);
        }

        // Return the final result, which represents the maximum product of a contiguous subarray
        return result;
    }


    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();

        int[] nums = {2, 3, -2, 4};
        int maxProduct = maxProductSubarray.maxProduct(nums);
        System.out.println("Maximum product of a subarray: " + maxProduct);
    }
}
