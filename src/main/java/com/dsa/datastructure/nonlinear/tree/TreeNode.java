package com.dsa.datastructure.nonlinear.tree;

public class TreeNode {

    public String value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String value) {
        this.value = value;
        left = right = null;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

}
