package org.example.Leetcode.dp;

// https://leetcode.com/problems/climbing-stairs/

import java.util.HashMap;

public class climbingStairs {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(map.containsKey(Integer.valueOf(n))) return map.get(n);
        int count = climbStairs(n-1);
        count += climbStairs(n-2);
        map.put(n,count);
        return count;
    }
}
