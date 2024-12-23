package org.example.Leetcode.arrays.slidingwindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=prefix-sum

public class MinimumSizeSubarraySum {
    // target = 7, nums = [2,3,1,2,4,3]
    public int minSubArrayLen(int target, int[] nums) {
        int total = nums[0];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0, j = 1; i < nums.length; ) {
            if (total >= target) {
                if (minLen > j - i) {
                    minLen = j - i;
                }
                total -= nums[i];
                i++;
            } else if (j >= nums.length) {
                break;
            } else {
                total += nums[j];
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0:minLen;
    }
}