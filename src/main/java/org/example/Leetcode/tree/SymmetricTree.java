package org.example.Leetcode.tree;

//https://leetcode.com/problems/symmetric-tree/submissions/1229213385/

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return magic(root.left, root.right);
    }

    private boolean magic(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return magic(left.left, right.right) && magic(left.right, right.left);
    }


}
