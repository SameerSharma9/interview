package org.example.Leetcode.arrays.prefixsum;

//https://leetcode.com/problems/product-of-array-except-self/?envType=problem-list-v2&envId=prefix-sum

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];

        int prod = 1;
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        prod = 1;
        suffix[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            suffix[i] = nums[i] * suffix[i+1];
        }

        ans[0] = suffix[1];
        ans[nums.length-1] = prefix[nums.length-2];
        for(int i = 1; i < nums.length-1; i++) {
            ans[i] = prefix[i-1] * suffix[i+1];
        }
        return ans;
    }
}
