package org.example.recursion;

// http://leetcode.com/problems/path-sum-ii/description/?envType=problem-list-v2&envId=backtracking

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        if(root == null) return res;

        dfs(root, targetSum ,  res, ls);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> tmp) {
        if(root == null) return ;
        tmp.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }

        dfs(root.left, targetSum-root.val, res, tmp);
        dfs(root.right, targetSum-root.val, res, tmp);
        tmp.remove(tmp.size()-1);
    }
}

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
