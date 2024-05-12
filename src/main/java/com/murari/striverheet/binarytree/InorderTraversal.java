package com.murari.striverheet.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr=root;
        List<Integer> result= new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private static void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        TreeNode curr=root;
        if(curr!=null){
            inorderTraversalHelper(curr.left, result);
            result.add(curr.val);
            inorderTraversalHelper(curr.right, result);
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Creating an instance of the Solution class


        // Calling the inorderTraversal method
        List<Integer> inorder = inorderTraversal(root);

        // Printing the result
        System.out.println("Inorder traversal: " + inorder);
    }
}

