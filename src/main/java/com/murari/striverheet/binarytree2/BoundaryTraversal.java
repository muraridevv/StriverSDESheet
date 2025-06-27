package com.murari.striverheet.binarytree2;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

  public void addLeftBoundary(TreeNode node, List<Integer> result) {
    if (node == null || (node.left == null && node.right == null)) return;

    result.add(node.val);

    if (node.left != null) {
      addLeftBoundary(node.left, result);
    } else {
      addLeftBoundary(node.right, result);
    }
  }

  public void addLeaves(TreeNode node, List<Integer> result) {
    if (node == null) return;

    if (node.left == null && node.right == null) {
      result.add(node.val);
    }

    addLeaves(node.left, result);
    addLeaves(node.right, result);
  }

  public void addRightBoundary(TreeNode node, List<Integer> result) {
    if (node == null || (node.left == null && node.right == null)) return;

    if (node.right != null) {
      addRightBoundary(node.right, result);
    } else {
      addRightBoundary(node.left, result);
    }
    result.add(node.val);
  }

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) return result;

    // Add root value
    result.add(root.val);

    // Add left boundary
    addLeftBoundary(root.left, result);

    // Add leaf nodes
    addLeaves(root, result);

    // Add right boundary
    addRightBoundary(root.right, result);

    return result;
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(10);

    // Calling the levelOrder method
    BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
    List<Integer> boundary = boundaryTraversal.boundaryOfBinaryTree(root);

    // Printing the level order traversal of the tree
    System.out.println("Boundary order traversal:" + boundary);
  }
}
