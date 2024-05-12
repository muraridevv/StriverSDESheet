package com.murari.striverheet.binarysearchtree;

public class NextRightPointers {

    public Node connect(Node root) {
        connectHelper(root,0);
        return root;
    }

    private void connectHelper(Node node, int level){
        if(node==null) return;

        if(node.left!=null){
            node.left.next=node.right;
        }

        if(node.right!=null && node.next!=null){
            node.right.next=node.next.left;
        }

        connectHelper(node.left, level+1);
        connectHelper(node.right, level+1);


    }
}
