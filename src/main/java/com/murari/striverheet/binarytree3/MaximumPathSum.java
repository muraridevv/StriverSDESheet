package com.murari.striverheet.binarytree3;

// This problem is similar to diameter of tree
public class MaximumPathSum {

    private int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumHelper(root);
        return maxSum;
    }
    private int maxSumHelper(TreeNode node){
        if(node==null) return 0;

        // Calculate the maximum sum of left and right subtrees
        int maxLeft = Math.max(maxSumHelper(node.left), 0);
        int maxRight = Math.max(maxSumHelper(node.right), 0);

        // Calculate the maximum sum of the path including the current node
        int currentMax = node.val + maxLeft + maxRight;

        // Update the global maximum sum
        maxSum = Math.max(maxSum, currentMax);

        return Math.max(maxLeft, maxRight)+ node.val;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode();
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumPathSum maximumPathSum=new MaximumPathSum();
        int sum= maximumPathSum.maxPathSum(root);
        System.out.println("Maximum Sum :"+sum);
    }
}
