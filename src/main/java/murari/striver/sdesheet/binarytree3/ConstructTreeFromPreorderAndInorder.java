package murari.striver.sdesheet.binarytree3;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length!= inorder.length || preorder.length==0){
            return null;
        }

        //Create a map to store the indices of the element in inorder
        Map<Integer, Integer> inorderMap= new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return null;
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     Map<Integer, Integer> inorderMap, int inStart, int inEnd,int preStart, int preEnd){

        if(preStart>preEnd || inStart> inEnd){
            return null;
        }

        TreeNode root= new TreeNode(preorder[preStart]);

        //Find the index of current root value in inorder traversal

        return null;
    }
}
