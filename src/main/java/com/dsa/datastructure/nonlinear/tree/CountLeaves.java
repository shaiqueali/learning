package com.dsa.datastructure.nonlinear.tree;


public class CountLeaves {

    public static void main(String[] args) {

    }

    private int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.isLeaf()) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

//    public int countLeafNodesRecursively() {
//        return countLeaves(root);
//    }
}
