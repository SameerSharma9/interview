package org.example.Leetcode.tree;

// https://leetcode.com/problems/recover-binary-search-tree/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecoverBST {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    public void recoverTree(TreeNode root) {
        compute(root, null, null);
    }

    private void compute(TreeNode node, Integer max, Integer min) {
        if(node == null) return;
        map.put(node.val, node);
        if(max != null && node.val < max) {
            int temp = node.val;
            node.val = max;
            map.get(max).val = temp;
            return;
        }
        if(min != null && node.val > min) {
            int temp = node.val;
            node.val = min;
            map.get(min).val = temp;
            return;
        }
        compute(node.left, max, node.val);
        compute(node.right, node.val, min);
    }

    public void recoverTree2(TreeNode root) {
        int val1 = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        inorder(root, ls);

        for(int i = 0; i < ls.size()-1; i++) {
            if(ls.get(i) >= ls.get(i+1)) {
                val1 = ls.get(i);
                System.out.print(val1);
                break;
            }
        }

        //System.out.print(val1);
        for(int i = ls.size()-1; i > 0; i--) {
            if(ls.get(i) < ls.get(i-1)) {
                //System.out.print(ls.get(i));
                TreeNode temp = map.get(val1);
                TreeNode temp2 = map.get(ls.get(i));
                //System.out.print(temp.val);
                //System.out.print(temp2.val);
                temp.val = temp2.val;
                temp2.val = val1;
                break;
            }
        }
    }
    private void inorder(TreeNode node, List<Integer> ls) {
        if(node == null) return;

        inorder(node.left, ls);
        ls.add(node.val);
        inorder(node.right, ls);
    }
}
