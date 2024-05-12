package murari.striver.sdesheet.binarysearchtree2;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack= new Stack<>();
        pushAllLeft(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node= stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node){
        while (node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}