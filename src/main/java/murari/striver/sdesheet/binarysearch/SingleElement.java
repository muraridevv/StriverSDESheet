package murari.striver.sdesheet.binarysearch;

public class SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        int result = 0;

        int low = 0;
        int high = nums.length - 1;
        int mid;

        // Boundary cases
        if(high==0){
            return nums[0];
        }
        if (nums[high] != nums[high - 1]) {
            return nums[high];
        } else if (nums[low] != nums[low + 1]) {
            return nums[low];
        }

        while (low <= high) {
            mid = low + (high - low) / 2;

            // Unique element condition
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static int singleNonDuplicateOptimized(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8}; // Expect 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11}; // Expect 10
        int[] nums3 = {1, 1, 2}; // Expect 2
        int[] nums4 = {1}; // Expect 1
        int[] nums5 = {1, 1, 2, 2, 3, 3, 4, 4, 5}; // Expect 5

        System.out.println("Single non-duplicate in nums1: " + singleNonDuplicateOptimized(nums1));
        System.out.println("Single non-duplicate in nums2: " + singleNonDuplicateOptimized(nums2));
        System.out.println("Single non-duplicate in nums3: " + singleNonDuplicateOptimized(nums3));
        System.out.println("Single non-duplicate in nums4: " + singleNonDuplicateOptimized(nums4));
        System.out.println("Single non-duplicate in nums5: " + singleNonDuplicateOptimized(nums5));
    }

}
