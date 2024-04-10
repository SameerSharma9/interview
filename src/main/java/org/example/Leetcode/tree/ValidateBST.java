package org.example.Leetcode.tree;

// https://leetcode.com/problems/validate-binary-search-tree/

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        inorder(root, ls);
        for(int i = 0; i < ls.size()-1; i++) {
            if(ls.get(i) >= ls.get(i+1)) return false;
        }
        return  true;
    }
    private void inorder(TreeNode node, List<Integer> ls) {
        if(node == null) return;

        inorder(node.left, ls);
        ls.add(node.val);
        inorder(node.right, ls);
    }
}
