package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/longest-well-performing-interval/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;

public class LongestWellperformingInterval {
    public int longestWPI(int[] hours) {
        int[] prefixSum = new int[hours.length + 1];
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        for(int n:hours) {
            if(n>8) {
                prefixSum[i] = prefixSum[i-1] + 1;
            } else {
                prefixSum[i] = prefixSum[i-1] - 1;
            }
            i++;
        }
        map.put(0, 0);
        if(hours.length == prefixSum[hours.length]) return hours.length;
        for(i = 1; i <= hours.length; i++) {
            if(map.containsKey(prefixSum[i]-1)) {
                maxLen = Math.max(maxLen, i-map.get(prefixSum[i]-1));
            }
            if(!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWellperformingInterval().longestWPI(new int[]{16,15,11,2,9,3}));
    }
}
