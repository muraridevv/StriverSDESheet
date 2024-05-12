package com.murari.striverheet.binarysearchtree2;

public class MaxBST {
    public int maxSumBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int isValid(TreeNode node, Integer min, Integer max){
        int sum=0;
        if(node==null) return 0;

        if(node.val<= min || node.val>= max) return 0;

        int leftValue= isValid(node.left, min, node.val);
        int rightValue= isValid(node.right, node.val, max);

        if(leftValue>=0 && rightValue>0){
            sum= leftValue+ rightValue+ node.val;
            return sum;
        }
        return -1;
    }


}
