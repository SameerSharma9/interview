package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/subarray-sum-equals-k/?envType=problem-list-v2&envId=prefix-sum

import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;

        map.put(0,1);

        for(int n : nums) {
            sum += n;
            int temp = sum - k;
            if(map.containsKey(temp)) {
                result += map.get(temp);
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }
        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int pSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            pSum += nums[i];
            if(map.containsKey(pSum - k)) {
                count += map.get(pSum - k);
            }
            if(map.containsKey(pSum)) {
                map.put(pSum, map.get(pSum) + 1);
            } else {
                map.put(pSum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        int s = new SubArraySumEqualsK().subarraySum(arr, 3);
        System.out.println(s);
    }
}
