package org.example.Leetcode.arrays.recursion;

// https://leetcode.com/problems/stone-game-iii/description/

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class StoneGame3 {

    Map<Integer, Integer> map = new HashMap<>();
    public String stoneGame3(int[] stoneValue) {
        Integer s = turn(stoneValue, 0);
        if(s > 0) return "Alice";
        else if(s < 0) return "Bob";
        else return "Tie";
    }

    public Integer turn(int[] stoneValue, int i) {
        // base condition
        if(i >= stoneValue.length) {
            return 0;
        }
        Integer p1 = Integer.MIN_VALUE;
        Integer tmp = map.getOrDefault(i+1, turn(stoneValue, i+1));
        map.put(i+1, tmp);
        p1 = stoneValue[i] - tmp;


        Integer p2 = Integer.MIN_VALUE;
        if(i+1 < stoneValue.length){
            tmp = map.getOrDefault(i+2, turn(stoneValue, i+2));
            map.put(i+2, tmp);
            p2 = stoneValue[i] + stoneValue[i+1] - tmp;
        }

        Integer p3 = Integer.MIN_VALUE;
        if(i+2 < stoneValue.length){
            tmp = map.getOrDefault(i+3, turn(stoneValue, i+3));
            map.put(i+3, tmp);
            p3 = stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - tmp;
        }
        return Math.max(p1, Math.max(p2,p3));
    }

    public static void main(String[] args) {
        System.out.println(new StoneGame3().stoneGame3(new int[]{1,2,3,4,5,100}));
    }
}
