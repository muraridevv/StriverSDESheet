package com.murari.striverheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    private void dfs(List<List<Integer>> resultSet, List<Integer> currentSet, int[] candidates, int target, int index, int sum){

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
        dfs(resultSet, currentSet, candidates, target, index+1, sum+candidates[index]);//same element can be included multiple times

        //backtracking step
        currentSet.remove(currentSet.size()-1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++; // Skip duplicates
        }

        //Choice 2: Exclude the current element
        dfs(resultSet, currentSet, candidates, target, index+1, sum);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    public static void main(String args[]) {

        CombinationSum2 combinationSum= new CombinationSum2();
        List<List< Integer >> ans = combinationSum.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println("each subset is ");
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
