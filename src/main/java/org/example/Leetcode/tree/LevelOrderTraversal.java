package org.example.Leetcode.tree;

// https://leetcode.com/problems/binary-tree-level-order-traversal/

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderTraversal {
    List<Pair<Integer, Integer>> levelList = new ArrayList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 1);
        //levelList.stream().collect(Collectors.groupingBy(x->x.getValue(), TreeMap::new, Collectors.mapping(y->y.getValue()), Collectors.toList()));
        return map.entrySet().stream().map(x-> x.getValue()).collect(Collectors.toList());
    }

    private void dfs(TreeNode node, int level) {
        if(node == null) return;

        //levelList.add(new Pair<>(node.val, level));
        List<Integer> ls = map.getOrDefault(level, new ArrayList<>());
        ls.add(node.val);
        map.put(level, ls);
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}

