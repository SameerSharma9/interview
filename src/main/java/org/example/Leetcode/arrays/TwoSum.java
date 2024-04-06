package org.example.Leetcode.arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = null;
        for(int i = 0; i < nums.length; i++)  {
            if(map.containsKey(nums[i])) {
                res = new int[]{map.get(nums[i]), i};
            }else {
                map.put(target - nums[i], i);
            }
        }
        return res;
    }
}
