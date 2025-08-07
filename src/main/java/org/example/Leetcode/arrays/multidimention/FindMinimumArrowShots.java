package org.example.Leetcode.arrays.multidimention;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=problem-list-v2&envId=greedy

import java.util.Arrays;
import java.util.Comparator;

public class FindMinimumArrowShots {
    //Input: points = [[10,16],[2,8],[1,6],[7,12]]
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x,y) -> Integer.compare(x[0] , y[0]));
        int arrow = 1;
        int min = points[0][0];
        int max = points[0][1];
        for(int i = 1; i < points.length;i++) {
            if(max < points[i][0]) {
                arrow++;
                min = points[i][0];
                max = points[i][1];
            } else {
                min = Math.max(min, points[i][0]);
                max = Math.min(max, points[i][1]);
            }

        }
        return arrow;
    }
    public static void main(String[] args) {
        FindMinimumArrowShots solution = new FindMinimumArrowShots();
        int[][] points = {
                {1,2},{2,3},{3,4},{4,5}
        };
        int result = solution.findMinArrowShots(points);
        System.out.println("Minimum number of arrows required: " + result);
    }
}
