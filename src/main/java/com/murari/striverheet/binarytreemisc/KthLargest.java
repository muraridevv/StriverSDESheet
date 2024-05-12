package com.murari.striverheet.binarytreemisc;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap= new PriorityQueue<>(k);
        this.k=k;

        for(int num: nums){
           minHeap.offer(num);
           if(minHeap.size()>k) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k) minHeap.poll();

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println("kthLargest.add(3): " + kthLargest.add(3));   // return 4
        System.out.println("kthLargest.add(5): " + kthLargest.add(5));   // return 5
        System.out.println("kthLargest.add(10): " + kthLargest.add(10));  // return 5
        System.out.println("kthLargest.add(9): " + kthLargest.add(9));   // return 8
        System.out.println("kthLargest.add(4): " + kthLargest.add(4));   // return 8
    }
}
