package com.murari.striverheet.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
  public static List<Integer> leftViewTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    leftViewTraversalHelper(root, 0, result);
    return result;
  }

  private static void leftViewTraversalHelper(TreeNode root, int level, List<Integer> result) {
    if (root != null) {
      if (level == result.size()) result.add(root.val);
      leftViewTraversalHelper(root.left, level + 1, result);
      leftViewTraversalHelper(root.right, level + 1, result);
    }
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    // Creating an instance of the Solution class

    // Calling the inorderTraversal method
    List<Integer> leftView = leftViewTraversal(root);

    // Printing the result
    System.out.println("Left view: " + leftView);
  }
}
