package murari.striver.sdesheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum1 {

    private static void subsetSumHelper(int index, int sum, List<Integer> nums, int size, List<Integer> result){
        if(index==size){
            result.add(sum);
            return;
        }

        //pick the element
        subsetSumHelper(index+1, nums.get(index)+ sum, nums, size, result);

        //not pick the element
        subsetSumHelper(index+1, sum, nums, size, result);
    }

    public static List<Integer> subsetSums(List<Integer> nums, int size){
        List<Integer> result= new ArrayList<>();
        subsetSumHelper(0, 0, nums, size, result);
        return result;
    }

    public static void main(String args[]) {


        ArrayList< Integer > arr = new ArrayList < > ();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        List < Integer > ans = subsetSums(arr, arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
