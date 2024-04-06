package org.example.Leetcode.tree;

// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/?envType=daily-question&envId=2024-03-14


import javafx.util.Pair;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

public class CountNodeEqualAverage {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        getAvrPir(root);
        return res;
    }

    private Pair<Integer, Integer> getAvrPir(TreeNode node) {
        if(node == null) return new Pair<Integer,Integer>(0,0);
        Pair<Integer, Integer> left = getAvrPir(node.left);
        Pair<Integer, Integer> right = getAvrPir(node.right);
        System.out.println();
        if((left.getKey()+right.getKey()+node.val)/(left.getValue()+right.getKey()+1) == node.val) res++;
        return new Pair<>(left.getKey()+right.getKey()+node.val, left.getValue()+right.getKey()+1);
    }
}
