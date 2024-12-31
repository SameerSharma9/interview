package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;
import java.util.Map;

public class CountNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int prefix = 0;
        int ans = 0;
        freq.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i] % 2 == 0 ? 0:1;
            prefix += num;
            freq.put(prefix, freq.getOrDefault(prefix,0) + 1);
            if(freq.containsKey(prefix-k)) {
                ans += freq.get(prefix-k);
            }
        }
        return ans;
    }
}
