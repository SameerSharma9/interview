package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/contiguous-array/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1?1:-1;
            if(map.containsKey(sum)) {
                if(res < i - map.get(sum)) {
                    res = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
