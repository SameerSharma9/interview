package org.example.Leetcode.tree;

// https://leetcode.com/problems/unique-binary-search-trees-ii/

import javafx.util.Pair;

import java.util.*;

public class UniqueBST2 {
    Map<Pair<Integer, Integer>, List<List<Integer>>> map= new HashMap<>();

    public List<TreeNode2> generateTrees(int n) {
        return compute2(1,n);
    }

    private List<TreeNode2> compute2(int start, int end) {
        if (start >= end) {
            TreeNode2 node = null;
            if (start == end)
                node = new TreeNode2(start);
            List<TreeNode2> ls = new ArrayList<>();
            ls.add(node);
            return ls;
        }
        //List<List<Integer>> res = new ArrayList<>();
        List<TreeNode2> res = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            int leftStart = start;
            int leftEnd = i - 1;
            int rightStart = i + 1;
            int rightEnd = end;
            List<TreeNode2> left = compute2(leftStart, leftEnd);

            List<TreeNode2> right = null;
            //if (rightStart <= rightStart)
                right = compute2(rightStart, rightEnd);


            for (int k = 0; k < left.size(); k++) {
                for (int j = 0; j < right.size(); j++) {
                    TreeNode2 node = new TreeNode2(i);
                    node.left = left.get(k);
                    node.right = right.get(j);
                    res.add(node);
                }
            }

        }
        return res;
    }

    //post order traversal
    private List<List<Integer>> compute(int start, int end) {
        if (start >= end) {
            ArrayList<Integer> rtList = new ArrayList<>();
            if (start > end)
                rtList.add(null);
            else
                rtList.add(start);
            ArrayList rs = new ArrayList();
            rs.add(rtList);
            return rs;
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            int leftStart = start;
            int leftEnd = i - 1;
            int rightStart = i + 1;
            int rightEnd = end;
            List<List<Integer>> left = map.getOrDefault(new Pair<>(leftStart, leftEnd), compute(leftStart, leftEnd));
            map.put(new Pair<>(leftStart,leftEnd), left);
            List<List<Integer>> right = Collections.emptyList();
            if (rightStart <= rightStart)
                right = map.getOrDefault(new Pair<>(rightStart,rightEnd), compute(rightStart, rightEnd));
            map.put(new Pair<>(rightStart,rightEnd), right);


            for (int k = 0; k < left.size(); k++) {
                for (int j = 0; j < right.size(); j++) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.addAll(left.get(k));
                    tmp.addAll(right.get(j));
                    res.add(tmp);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new UniqueBST2().compute(1,3);
        res.stream().forEach(System.out::println);

        List<TreeNode2> res2 = new UniqueBST2().generateTrees(3);

    }

}
class TreeNode2 {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2() {}
      TreeNode2(int val) { this.val = val; }
      TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
