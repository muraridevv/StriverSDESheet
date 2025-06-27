package com.murari.striverheet.binarytree2;

public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // If both nodes are null, they are equal
    if (p == null && q == null) return true;

    // If one node is null and the other is not, they are not equal
    if (p == null || q == null) return false;

    // If values of nodes p and q are different, they are not equal
    if (p.val != q.val) return false;

    boolean isSameLeft = isSameTree(p.left, q.left);
    boolean isSameRight = isSameTree(p.right, q.right);

    return isSameLeft && isSameRight;
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    // Calling the isBalanced method
    SameTree sameTree = new SameTree();
    boolean isSame = sameTree.isSameTree(root, root.right);

    // Printing the level order traversal of the tree
    System.out.println("Is tree identical? : " + isSame);
  }
}
