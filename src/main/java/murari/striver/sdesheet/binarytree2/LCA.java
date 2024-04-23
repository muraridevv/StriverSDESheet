package murari.striver.sdesheet.binarytree2;

public class LCA {

//      if both p and q exist in Tree rooted at root, then return their LCA
//      if neither p and q exist in Tree rooted at root, then return null
//      if only one of p or q (NOT both of them), exists in Tree rooted at root, return it
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode leftSubTree= lowestCommonAncestor(root.left, p, q);

        TreeNode rightSubTree= lowestCommonAncestor(root.right, p, q);
        if(leftSubTree==null) return rightSubTree;
        else if(rightSubTree==null) return leftSubTree;
        else return root;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling the isBalanced method
        LCA lca= new LCA();
        TreeNode  lcaTree = lca.lowestCommonAncestor(root, root.right.left, root.right.right);

        // Printing the level order traversal of the tree
        System.out.println("Balanced Tree? : "+lcaTree.val);

    }
}
