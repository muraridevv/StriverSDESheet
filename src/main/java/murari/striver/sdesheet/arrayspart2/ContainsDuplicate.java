package murari.striver.sdesheet.arrayspart2;

import java.util.Arrays;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i< nums.length; i++){
            if(nums[i-1]==nums[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate duplicate= new ContainsDuplicate();
        int [] arr=new int[]{3,5,9,6,0,3,8,4,7,1};
        boolean isduplicate= duplicate.containsDuplicate(arr);
        System.out.println("The array contains duplicate : "+isduplicate);
    }
}
