package com.murari.striverheet.linkedlistandarrays;

import java.util.List;
import java.util.Map;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;

        // Initialize arrays to store max heights to the left and right of each index
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize the first elements of left and right arrays
        left[0] = height[0];
        right[n - 1] = height[n - 1];

        // Calculate max heights to the left of each index
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        // Calculate max heights to the right of each index
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // Calculate amount of water trapped
        // Trapped water at each index: min(left, right) - height[i]
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            trapped += Math.min(right[i], left[i]) - height[i];
        }

        return trapped;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};

        int trapped = trap(nums);

        // Printing the triplets
        System.out.println("Water trapped : "+trapped);

    }
}
