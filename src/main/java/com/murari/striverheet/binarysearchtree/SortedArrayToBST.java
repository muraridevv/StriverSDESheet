package com.murari.striverheet.binarysearchtree;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return constructBST(nums,0, nums.length-1);
    }

    public TreeNode constructBST(int[] nums, int left, int right){
        if(left> right) return null;

        //find mid of nums
        int mid= left + (right- left)/2;
         TreeNode node= new TreeNode(nums[mid]);

         node.left= constructBST(nums, left, mid-1);
         node.right= constructBST(nums, mid, right);

         return node;
    }
}
