package murari.striver.sdesheet.linkedlistandarrays;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        // Example array with consecutive ones and zeros
        int[] nums = {1, 1, 0, 1, 1, 1};

        // Call the findMaxConsecutiveOnes method to find the maximum consecutive ones
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);

        // Print the result
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int localMax = 0;

        for (int num : nums) {
            localMax = (num == 1) ? localMax + 1 : 0; // Increment localMax if num is 1, otherwise reset it to 0
            maxOnes = Math.max(localMax, maxOnes); // Update maxOnes if localMax is greater
        }

        return maxOnes;
    }
}
