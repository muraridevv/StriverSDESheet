package murari.striver.sdesheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    private static void subSetsWithDupHelper(int index, List<Integer> subset, int[] nums, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));
        for(int i=index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            subSetsWithDupHelper(i+1,subset, nums, result);
            subset.remove(subset.size()-1);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subSetsWithDupHelper(0, new ArrayList<>(), nums, result);
        return result;
    }

    public static void main(String args[]) {


        ArrayList< Integer > arr = new ArrayList < > ();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        List< List< Integer >> ans = subsetsWithDup(new int[]{3,1,2});
//        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
