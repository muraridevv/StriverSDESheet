package murari.striver.sdesheet.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        //count the frequency of each number using HashMap
        Map<Integer,Integer> frequencyMap= new HashMap<>();

        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }

        // Use PriorityQueue (MaxHeap) to store entries based on frequency
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
            maxHeap.offer(entry);
        }

        int[] result= new int[k];
        for(int i=0;i<k;i++){
            result[i]=maxHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TopKFrequent TopKFrequent = new TopKFrequent();

        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = TopKFrequent.topKFrequent(nums1, k1);
        System.out.println("Example 1:");

        // Example 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = TopKFrequent.topKFrequent(nums2, k2);
        System.out.println("\nExample 2:");
    }
}
