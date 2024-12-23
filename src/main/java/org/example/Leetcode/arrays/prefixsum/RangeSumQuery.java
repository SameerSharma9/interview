package org.example.Leetcode.arrays.prefixsum;

//https://leetcode.com/problems/range-sum-query-immutable/?envType=problem-list-v2&envId=prefix-sum

import java.util.Arrays;

public class RangeSumQuery {

    int[] prefix;
    public RangeSumQuery(int[] nums) {
        prefix = new int[nums.length];
        for(int i = 0, s = 0; i < nums.length; i++) {
            prefix[i] = s + nums[i];
            s = prefix[i];
        }
    }

    public int sumRange(int left, int right) {

        if(left == 0) return prefix[right];
        return prefix[right] - prefix[left-1];
    }

}
