package com.murari.striverheet.arrayspart4;

//https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
public class RepeatAndMissingNumber {

    public int[] findRepeatAndMissing(int[] nums){
        int repeated = 0;
        int missing = 0;
        int[] countFreq= new int[nums.length];

        for(int i=0; i< nums.length; i++){
            countFreq[i]+= countFreq[i];
        }
        for(int i=0; i< countFreq.length; i++){
            if(countFreq[i]==2) repeated=i;
            else if( countFreq[i]==0) missing=i;
        }
        return new int[]{missing,repeated};
    }

    public static void main(String[] args) {
        RepeatAndMissingNumber solver = new RepeatAndMissingNumber();

        // Example input
        int[] nums = {4, 3, 6, 2, 1, 1};

        // Find the repeating and missing numbers
        int[] result = solver.findRepeatAndMissing(nums);

        // Print the result
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }
}
