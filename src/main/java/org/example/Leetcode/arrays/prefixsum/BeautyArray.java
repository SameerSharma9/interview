package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/?envType=daily-question&envId=2024-12-11

import java.util.Arrays;
import java.util.TreeMap;

public class BeautyArray {
    public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for(int n : nums) {
            for(int i = n-k; i <= n + k; i++) {
                if(sortedMap.containsKey(i)) {
                    sortedMap.put(i,sortedMap.get(i)+1);
                } else {
                    sortedMap.put(i,1);
                }
            }
        }
        System.out.println(sortedMap);
        return sortedMap.values().stream().max(Integer::compare).get();

    }

    public int maximumBeautyPrefixSum(int[] nums, int k) {
        //Input: nums = [4,6,1,2], k = 2

        /*
        4,6,1,2
        0 1 2 3 4 5 6 7 8 9
        0 0 1 0 0 0 0 -1 0 0
        0 0 0 0 1 0 0 0 0 -1
        1 0 0 0 -1 0 0 0 0
        1 0 0 0 0 -1 0 0 0
        2 2 3 3 3 2 2 2
         */
        int[] prefixArr = new int[Arrays.stream(nums).max().getAsInt() + k + 2];
        for(int n : nums) {
            if(n-k > -1)
                prefixArr[n-k]++;
            else
                prefixArr[0]++;
            prefixArr[n+k+1]--;
        }
        int max = 0;
        for(int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] =prefixArr[i-1] + prefixArr[i];
            if(max < prefixArr[i])
                max = prefixArr[i];
        }
        return max;
    }

    public int maximumBeautySlidingWindow(int[] nums, int k) {
        /*
        4,6,1,2
        1,2,4,6

         */
        Arrays.sort(nums);
        int max = 1;
        for(int i = 0, j = 1; j < nums.length; j++) {
            if(nums[i] + k >= nums[j]-k) {
                max = Math.max(max, j-i+1);
            } else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new BeautyArray().maximumBeauty(new int[]{4,6,1,2},2));
    }
}
