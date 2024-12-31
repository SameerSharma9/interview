package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        int prefix = 0, mod = 0, res = 0;
        modMap.put(0,1);
        for(int n : nums) {
            prefix += n;
            mod = prefix%k;
            if(mod < 0) {
                mod = mod+k;
            }
            if(modMap.containsKey(mod)) {
                res += modMap.get(mod);
                modMap.put(mod, modMap.get(mod)+1);
            } else {
                modMap.put(mod, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumDivByK().subarraysDivByK(new int[]{2,-2,2,-4},6));
    }
}