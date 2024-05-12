package murari.striver.sdesheet.binarysearchtree2;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {


    public int kthSmallest(TreeNode root, int k) {
        TreeNode answer= new TreeNode();
        inOrderTraversal(root,0, answer, k);
        return answer.val;
    }

    private void inOrderTraversal(TreeNode node,int count, TreeNode answer, int k){
        if(node==null)
            return;

        inOrderTraversal(node.left,count, answer, k);
        count++;
        if(count==k){
            answer.val=node.val;
            return;
        }
        inOrderTraversal(node.right,count, answer, k);
    }
}
