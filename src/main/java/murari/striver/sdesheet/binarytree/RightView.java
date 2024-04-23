package murari.striver.sdesheet.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RightView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        rightViewTraversalHelper(root, 0, result);
        return result;
    }

    private static void rightViewTraversalHelper(TreeNode root, int level, List<Integer> result) {
        if(root !=null){
            if(level== result.size()) {
                result.add(root.val);
            }
            rightViewTraversalHelper(root.right, level + 1, result);
            rightViewTraversalHelper(root.left, level + 1, result);


        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Creating an instance of the Solution class


        // Calling the inorderTraversal method
        List<Integer> rightView = rightSideView(root);

        // Printing the result
        System.out.println("Right view: " + rightView);
    }
}
