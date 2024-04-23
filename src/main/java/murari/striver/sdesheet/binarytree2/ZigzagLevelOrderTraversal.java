package murari.striver.sdesheet.binarytree2;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        zigzagLevelOrderHelper(root, 0, result);
        return result;
    }

    public void zigzagLevelOrderHelper(TreeNode node,int level,  List<List<Integer>> result){
        if(node==null) return;

        if(level==result.size())
            result.add(new ArrayList<>());

        if (level % 2 == 0) {
            // If level is even, add to the current level list
            result.get(level).add(node.val);
        } else {
            // If level is odd, add to the current level list in reverse order
            result.get(level).add(0, node.val);
        }

        // Recursively call helper method for left and right subtrees with updated level
        zigzagLevelOrderHelper(node.left, level + 1, result);
        zigzagLevelOrderHelper(node.right, level + 1, result);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the levelOrder method
        ZigzagLevelOrderTraversal zigzagLevelOrderTraversal = new ZigzagLevelOrderTraversal();
        List<List<Integer>> levels = zigzagLevelOrderTraversal.zigzagLevelOrder(root);

        // Printing the level order traversal of the tree
        System.out.println("Level order traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
