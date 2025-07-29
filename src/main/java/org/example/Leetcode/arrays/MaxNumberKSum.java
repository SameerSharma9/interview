package org.example.Leetcode.arrays;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75

import java.util.HashMap;

public class MaxNumberKSum {

    //Input: nums = [1,2,3,4], k = 5
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(k-nums[i])) {
                result++;
                if(map.get(k-nums[i]) == 1)
                    map.remove(k - nums[i]);
                else
                    map.put(k-nums[i], map.get(k-nums[i])-1);
            } else {
                if(map.containsKey(nums[i]))
                    map.put(nums[i], map.get(nums[i])+1);
                else
                    map.put(nums[i], 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int res = new MaxNumberKSum().maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3);
        System.out.println(res);
    }
}
