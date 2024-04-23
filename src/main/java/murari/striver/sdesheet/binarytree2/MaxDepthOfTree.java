package murari.striver.sdesheet.binarytree2;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfTree {
    public static int levelOrder(TreeNode root) {
        int result=0;
        result= levelOrderHelper(root, 0);
        return result;
    }

    private static int levelOrderHelper(TreeNode node, int level){
        if(node==null) {
            return level;
        }
        int leftHeight= levelOrderHelper(node.left, level+1);
        int rightHeight= levelOrderHelper(node.right, level+1);
        return Math.max(leftHeight, rightHeight);

    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the levelOrder method
        int  levels = levelOrder(root);

        // Printing the level order traversal of the tree
        System.out.println("Level order traversal: "+levels);

    }
}
