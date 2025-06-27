package com.murari.striverheet.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preOrderTraversalHelper(root, result);
    return result;
  }

  private static void preOrderTraversalHelper(TreeNode root, List<Integer> result) {
    if (root != null) {
      result.add(root.val);
      preOrderTraversalHelper(root.left, result);
      preOrderTraversalHelper(root.right, result);
    }
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    // Creating an instance of the Solution class

    // Calling the inorderTraversal method
    List<Integer> inorder = preorderTraversal(root);

    // Printing the result
    System.out.println("Inorder traversal: " + inorder);
  }
}
