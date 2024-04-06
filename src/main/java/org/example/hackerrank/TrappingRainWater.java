package org.example.hackerrank;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(arr));
    }
}

class Solution {
    public int trap(int[] height) {
            int[] left = new int[height.length];
            int[] right = new int[height.length];
            Arrays.fill(left,0);
            Arrays.fill(right,0);
            for(int i = 1; i < height.length; i++) {
                if(height[i-1] > left[i-1]) {
                    left[i] = height[i-1];
                } else {
                    left[i] = left[i-1];
                }
            }
            for(int i = height.length-2; i >= 0; i--) {
                if(height[i+1] > right[i+1]) {
                    right[i] = height[i+1];
                } else {
                    right[i] = right[i+1];
                }
            }
            int sum = 0;
            for(int i = 1; i < height.length-1; i++) {
                if(Math.min(left[i], right[i]) - height[i] > 0) {
                    sum += Math.min(left[i], right[i]) - height[i];
                }
            }
            return sum;
    }
}
