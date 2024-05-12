package com.murari.striverheet.binarytree2;

public class DiameterOfTree {

    private static int diameter=0;
    public static int diameterOfBinaryTree(TreeNode root) {

        diameterOfBinaryTreeHelper(root);
        return diameter;
    }

    private static int diameterOfBinaryTreeHelper(TreeNode node){
        if(node==null)
            return 0;

        int leftHeight= diameterOfBinaryTreeHelper(node.left);
        int rightHeight= diameterOfBinaryTreeHelper(node.right);

        diameter= Math.max(diameter, leftHeight+ rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the levelOrder method
        int  diameterOfBinaryTree = diameterOfBinaryTree(root);

        // Printing the level order traversal of the tree
        System.out.println("Level order traversal: "+diameterOfBinaryTree);

    }
}
