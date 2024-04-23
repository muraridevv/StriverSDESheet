package murari.striver.sdesheet.binarytree2;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, 0, result);
        return result;
    }

    private static void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result){
        if(node!=null){
            if(result.size()==level)
                result.add(new ArrayList<>());

            result.get(level).add(node.val);
            levelOrderHelper(node.left, level+1, result);
            levelOrderHelper(node.right, level+1, result);
        }
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the levelOrder method
        List<List<Integer>> levels = levelOrder(root);

        // Printing the level order traversal of the tree
        System.out.println("Level order traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}
