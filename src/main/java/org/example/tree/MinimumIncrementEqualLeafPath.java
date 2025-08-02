package org.example.tree;

//https://leetcode.com/problems/minimum-increments-to-equalize-leaf-paths/description/

import java.util.ArrayList;
import java.util.List;

public class MinimumIncrementEqualLeafPath {

    private int count = 0;

    //Input: n = 5, edges = [[0,4],[0,1],[1,2],[1,3]], cost = [3,4,1,1,7]
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,adjList, cost);
        return count;
    }

    private int dfs(int node, int parent, List<List<Integer>> adjList, int[] cost) {
        if(adjList.get(node).size() == 1 && parent != -1) {
            return cost[node];
        }

        List<Integer> children = new ArrayList<>();
        for(Integer child : adjList.get(node)) {
            if(child == parent) continue;
            children.add(dfs(child, node, adjList, cost));
        }
        int max = children.stream().mapToInt(Integer::valueOf).max().getAsInt();
        for(Integer a : children) {
            if(max != a) count++;
        }
        return cost[node] + max;
    }
}
