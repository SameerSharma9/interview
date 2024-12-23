package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/continuous-subarray-sum/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum % k;
            if(map.containsKey(rem)) {
                if(i - map.get(rem) >= 2) return true;
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
