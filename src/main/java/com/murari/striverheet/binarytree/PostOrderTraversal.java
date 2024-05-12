package com.murari.striverheet.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }

    private static void postorderTraversalHelper(TreeNode root, List<Integer> result) {
        if(root !=null){
            postorderTraversalHelper(root.left, result);
            postorderTraversalHelper(root.right, result);
            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Creating an instance of the Solution class


        // Calling the inorderTraversal method
        List<Integer> inorder = postorderTraversal(root);

        // Printing the result
        System.out.println("PostOrder traversal: " + inorder);
    }
}
