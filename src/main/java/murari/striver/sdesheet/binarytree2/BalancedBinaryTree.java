package murari.striver.sdesheet.binarytree2;

public class BalancedBinaryTree {

    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {

        return isBalancedHelper(root)!=-1;
    }

    public int isBalancedHelper(TreeNode node){
        if(node==null) return 0;

        int leftHeight= isBalancedHelper(node.left);
        int rightHeight= isBalancedHelper(node.right);

        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the isBalanced method
        BalancedBinaryTree balancedBinaryTree= new BalancedBinaryTree();
        boolean  isBalanced = balancedBinaryTree.isBalanced(root);

        // Printing the level order traversal of the tree
        System.out.println("Balanced Tree? : "+isBalanced);

    }
}
