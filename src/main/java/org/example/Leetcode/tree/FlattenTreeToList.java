package org.example.Leetcode.tree;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=problem-list-v2&envId=stack

public class FlattenTreeToList {
    public void flatten(TreeNode root) {
        if(root == null) return ;
    }

    private TreeNode traverse(TreeNode n) {
        if(n == null || (n.left == null && n.right == null)) return n;
        //print
        TreeNode right = null;
        if(n.left == null) {
            right = traverse(n.right);
            //return n.right;
        } else {
            TreeNode left = traverse(n.left);
            right = traverse(n.right);
            //if(left == null && right == null) return n;
            left.right = n.right;
            n.right = n.left;
            n.left = null;

        }
        return right;


    }
}
