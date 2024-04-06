package org.example.hackerrank.array;

//https://www.hackerrank.com/challenges/cut-the-tree/problem?isFullScreen=true

import java.util.*;
import java.util.stream.Collectors;

public class CutTheTree {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(1,3));
        edges.add(Arrays.asList(2,6));
        edges.add(Arrays.asList(3,4));
        edges.add(Arrays.asList(3,5));
        List<Integer> data = Arrays.asList(1,2,3,4,5,6);
        int min = CutTheTree.cutTheTree(data, edges);
        System.out.println(min);
    }

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        int sum[] = new int[data.size()];
        Arrays.fill(sum,0);
        Map<Integer, List<Integer>> v = new HashMap<>();
        for(List<Integer> e : edges) {
            Integer node1 = e.get(0);
            Integer node2 = e.get(1);

            if(!v.containsKey(node1)) {
                v.put(node1, new ArrayList<>());
            }
            if(!v.containsKey(node2)) {
                v.put(node2, new ArrayList<>());
            }
            v.get(node1).add(node2);
            v.get(node2).add(node1);
        }

        CutTheTree.dfs(data, new boolean[data.size()], v, sum);

        Integer min = Integer.MAX_VALUE;
        for(List<Integer> e : edges) {

            int temp = Math.abs(sum[0] - sum[e.get(1)-1] - sum[e.get(1)-1] );
            System.out.println(temp);
            if(min > temp) {
                min = temp;
            }
        }
        return min;

    }

     static void dfs(List<Integer> data, boolean visited[],
                     Map<Integer, List<Integer>> v, int sum[])  {
        Stack<Integer> stack = new Stack<>();
        Integer cur = 1;
        stack.push(cur);

        while(!stack.isEmpty()) {
            cur = stack.peek();
            visited[cur-1] = true;
            boolean done = true;
            for(Integer e : v.get(cur)) {
                if(!visited[e-1]) {
                    stack.push(e);
                    done = false;
                    break;
                }
            }
            if(done) {
                sum[cur-1] = data.get(cur - 1);
                for(Integer e : v.get(cur)) {
                    sum[cur-1] += sum[e-1];
                }
                stack.pop();
            }
        }

    }
}
