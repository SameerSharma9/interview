package org.example.Leetcode.arrays;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubArray {
    //[-2,-1,-3,-4,-1,-2,-1,-5,4]
    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int res = 0;
        res = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(maxSum + nums[i] <= 0) {
                maxSum = 0;
            } else {
                maxSum += nums[i];
            }
            if(res < maxSum && maxSum != 0) {
                res = maxSum;
            } else if(res < nums[i]) {
                res = nums[i];
            }
        }
        return res;
    }

}
