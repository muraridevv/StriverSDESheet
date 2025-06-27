package com.murari.striverheet.binarysearchtree2;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {

  public boolean findTarget(TreeNode root, int k) {
    List<Integer> result = new ArrayList<>();
    inOrderTraversal(root, result);

    // find the two sum in the result list-> Now it has become similar to two sum problem in sorted
    // array
    // Use two pointer approach
    int left = 0;
    int right = result.size() - 1;
    while (left < right) {
      int sum = result.get(left) + result.get(right);
      if (sum < k) {
        left++;
      } else if (sum > k) {
        right--;
      } else {
        return true;
      }
    }

    return false;
  }

  private void inOrderTraversal(TreeNode node, List<Integer> result) {
    if (node == null) return;

    // visit left, node, right
    inOrderTraversal(node.left, result);
    result.add(node.val);
    inOrderTraversal(node.right, result);
  }

  public static TreeNode arrayToBST(int[] nums, int left, int right) {
    if (left > right) return null;

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = arrayToBST(nums, left, mid - 1);
    root.right = arrayToBST(nums, mid + 1, right);

    return root;
  }

  public static void main(String[] args) {
    // Example input
    int[] nums = {2, 3, 4, 5, 6, 7};
    int k = 9;

    // Construct BST from array
    TreeNode root = arrayToBST(nums, 0, nums.length - 1);

    // Create an instance of the Solution class
    TwoSumIV twoSumIV = new TwoSumIV();

    // Call the findTarget method and print the result
    System.out.println(
        "Does there exist two elements with sum "
            + k
            + " in the BST? "
            + twoSumIV.findTarget(root, k));
  }
}
