package org.example.Leetcode.arrays.slidingwindow;

// https://leetcode.com/problems/subarray-product-less-than-k/?envType=problem-list-v2&envId=prefix-sum

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0, prod = 1, res = 0;
        while(j < nums.length) {
            prod *= nums[j];
            if(prod >= k) {
                while(prod >= k && i <= j) {
                    prod /= nums[i];
                    i++;
                }
            }
            res = res + (j-i+1);
            j++;
        }
        return res;
    }
}
