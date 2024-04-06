package org.example.Leetcode.arrays;

// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.HashSet;

public class LargestRectInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1) return heights[0];
        int[] arr = new int[heights.length];
        HashSet<Integer> set = new HashSet<>();

        if(heights[1] < heights[0] && heights[1] != 0) {
            arr[0] = heights[1];
        } else {
            arr[0] = heights[0];
        }

        if(heights[heights.length-2] < heights[heights.length-1]  && heights[heights.length-2] != 0) {
            arr[heights.length-1] = heights[heights.length-2];
        } else {
            arr[heights.length-1] = heights[heights.length-1];
        }
        set.add(arr[0]);
        set.add(arr[heights.length-1]);
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] == 0) heights[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i < heights.length-1; i++) {
            if(heights[i] < heights[i-1] || heights[i] < heights[i+1]) {
                arr[i] = heights[i];
            } else {
                arr[i] = heights[i-1] > heights[i+1]?heights[i-1]:heights[i+1];
            }
            set.add(arr[i]);
        }
        int max = 0;
        for(Integer i: set) {
            int maxCount = 0;
            int count = 0;
            for(int j = 0; j <  arr.length; j++) {
                if(i<= arr[j]) {
                    count++;
                } else {
                    maxCount = maxCount<count?count:maxCount;
                    count = 0;
                }
            }
            maxCount = maxCount<count?count:maxCount;
            max = maxCount*i > max ? maxCount*i : max;
        }
    return max;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectInHistogram().largestRectangleArea(new int[]{0,9,0}));
    }
}
