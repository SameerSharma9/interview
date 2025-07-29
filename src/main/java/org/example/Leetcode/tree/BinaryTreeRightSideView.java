package org.example.Leetcode.tree;

// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> ls = new HashMap<>();
        iterateTree(root, ls, 0);
        return new ArrayList<>(ls.values());
    }

    private void iterateTree(TreeNode root, HashMap<Integer, Integer> rightview, int level) {
        if(root == null) return;
        rightview.put(level, root.val);
        iterateTree(root.left, rightview, level + 1);
        iterateTree(root.right, rightview, level + 1);
    }
}
