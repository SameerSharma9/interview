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

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        int s = new SubArraySumEqualsK().subarraySum(arr, 3);
        System.out.println(s);
    }
}
