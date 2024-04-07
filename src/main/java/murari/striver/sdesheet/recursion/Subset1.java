package murari.striver.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {

    // Depth-first search function to generate subsets
    public void dfs(int i, ArrayList<Integer> curr, List<List<Integer>> result, int[] nums) {
        // If we have traversed all elements in nums, add the current subset to the result
        if (i >= nums.length) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        // Include nums[i] in the current subset
        curr.add(nums[i]);
        dfs(i + 1, curr, result, nums); // Recur with the next index

        // Exclude nums[i] from the current subset
        curr.remove(curr.size() - 1);
        dfs(i + 1, curr, result, nums); // Recur with the next index

        // Illustration:
        // Consider nums = [1, 2, 3]
        // At each level of the DFS tree, we decide whether to include or exclude the current element.
        // Starting from an empty subset [], we either include or exclude 1, then 2, then 3.
        // This process continues until we reach the end of nums.
        // For example, the DFS tree looks like this:
        //               []
        //           /         \
        //         [1]         []
        //       /     \      /    \
        //     [1,2]  [1]    [2]   []
        //    /   \   / \   /   \  / \
        // [1,2,3][1,3][2,3][1][2][3][]
        // Each path from the root to a leaf represents a subset of nums.
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>(); // Current subset being constructed
        dfs(0, curr, result, nums); // Start depth-first search from index 0
        return result;
    }

    public static void main(String args[]) {

        Subset1 subset1= new Subset1();
        List<List< Integer >> ans = subset1.subsets(new int[]{1,2,3});
        System.out.println("Each subset is ");
        for (List<Integer> an : ans) System.out.print(an + " ,");
    }
}
