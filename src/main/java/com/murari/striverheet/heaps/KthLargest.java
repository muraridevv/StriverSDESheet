package com.murari.striverheet.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>  priorityQueue= new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            priorityQueue.add(num);
        }

        for (int i=1;i<k;i++){
            priorityQueue.remove();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 5, 3};

        System.out.println(findKthLargest(arr, 3));
    }
}
