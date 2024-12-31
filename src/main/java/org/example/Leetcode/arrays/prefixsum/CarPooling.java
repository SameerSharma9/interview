package org.example.Leetcode.arrays.prefixsum;

//https://leetcode.com/problems/car-pooling/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    // trips = [[2,1,5],[3,3,7]], capacity = 4
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] n : trips) {
            int curCap = 0;
            if(map.containsKey(n[1])) {
                map.put(n[1], map.get(n[1])+n[0]);
            } else {
                map.put(n[1], n[0]);
            }
            if(map.containsKey(n[2])) {
                map.put(n[2], map.get(n[2])-n[0]);
            } else {
                map.put(n[2], (-1)*n[0]);
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                curCap += entry.getValue();
                if(curCap > capacity) return false;
            }
        }
        return true;
    }
}
