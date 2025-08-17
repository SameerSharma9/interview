package org.example.Leetcode.dp;

// https://leetcode.com/problems/triangle/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleShortestPath {
    /*
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null ) return 0;
        int min = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            triangle.get(i).set(0,triangle.get(i).get(0) + triangle.get(i-1).get(0));
            int j = 1;
            for(; j < triangle.get(i).size()-1; j++) {
                triangle.get(i).set(j,Math.min(triangle.get(i).get(j) + triangle.get(i-1).get(j-1), triangle.get(i).get(j) + triangle.get(i-1).get(j)));
            }
            triangle.get(i).set(j,triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
        }
        return triangle.get(triangle.size()-1).stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        TriangleShortestPath solver = new TriangleShortestPath();
        System.out.println(solver.minimumTotal(triangle)); // Output: 11
    }
}
