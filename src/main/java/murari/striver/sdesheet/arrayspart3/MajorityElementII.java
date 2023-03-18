package murari.striver.sdesheet.arrayspart3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int majority1=-1,majority2=-1,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(majority1==nums[i]){
                count1++;
            } else if (majority2==nums[i]) {
                count2++;
            }
            else if(count1==0){
                majority1=nums[i];
                count1++;
            } else if (count2==0) {
                majority2=nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> result=new ArrayList<>();
        count1=0;
        count2=0;
        for (int num : nums) {
            if (num == majority1) count1++;
            else if (num == majority2) count2++;
        }
        if(nums.length/3<count1) result.add(majority1);
        if(nums.length/3<count2) result.add(majority2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3,3,4,5,4,3,4,4}));
    }
}
