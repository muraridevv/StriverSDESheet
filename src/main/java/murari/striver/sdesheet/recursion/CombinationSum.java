package murari.striver.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public void dfs(List<List<Integer>> resultSet, List<Integer> currentSet, int[] candidates, int target, int index, int sum){
        if (sum == target) {
            resultSet.add(new ArrayList<>(currentSet));
            return;
        }

        if (index >= candidates.length || sum > target) {
            return;
        }

        //recursive call
        //Choice 1: Include the current element
        currentSet.add(candidates[index]);
        dfs(resultSet, currentSet, candidates, target, index, sum+candidates[index]);//same element can be included multiple times

        //backtracking step
        currentSet.remove(currentSet.size()-1);
        //Choice 2: Exclude the current element
        dfs(resultSet, currentSet, candidates, target, index+1, sum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet= new ArrayList<>();
        dfs(resultSet, new ArrayList<>(), candidates, target, 0, 0);
        return  resultSet;
    }

    public static void main(String args[]) {

        CombinationSum combinationSum= new CombinationSum();
        List<List< Integer >> ans = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
