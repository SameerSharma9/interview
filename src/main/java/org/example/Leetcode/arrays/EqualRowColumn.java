package org.example.Leetcode.arrays;

// https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualRowColumn {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
        }

        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[0].length; j++) {
                sb.append(grid[j][i]);
            }
            if(map.containsKey(sb.toString())) res += map.get(sb.toString());
        }
        return res;
    }
}
