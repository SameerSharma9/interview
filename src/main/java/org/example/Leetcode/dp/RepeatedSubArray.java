package org.example.Leetcode.dp;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

import java.util.Arrays;

public class RepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        Arrays.fill(dp,0);
        int max = 0;
        for(int i = 1; i <= nums2.length; i++) {
            for(int j = 1; i <= nums1.length; j++) {
                if(nums2[i] == nums1[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                if(max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
