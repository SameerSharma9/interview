package org.example.Leetcode.arrays;

// https://leetcode.com/problems/merge-intervals/description/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    // [[1,3],[3,3], [2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        List<Pair<Integer, Integer>> ls = Arrays.stream(intervals)
                .map(x-> new Pair<Integer,Integer>(x[0],x[1]))
                .sorted(Comparator.comparingInt(x->(int)x.getKey()))
                .collect(Collectors.toList());
        System.out.println(ls);
        List<Pair> resLs = new ArrayList<>();
        resLs.add(ls.get(0));
        for(int i = 1; i < ls.size();i++) {
            Pair<Integer, Integer> pairRs = ls.get(i);
            if((int)resLs.get(resLs.size()-1).getValue() < pairRs.getKey()) {
                resLs.add(pairRs);
            } else if((int)resLs.get(resLs.size()-1).getValue() >= pairRs.getValue()) {
                continue;
            } else if((int)resLs.get(resLs.size()-1).getValue() < pairRs.getValue()) {
                Pair<Integer, Integer> p = new Pair<>((int)resLs.get(resLs.size()-1).getKey(),pairRs.getValue());
                resLs.remove(resLs.size()-1);
                resLs.add(p);
            }
        }

        System.out.println(resLs);
        int[][] res = new int[resLs.size()][2];
        for(int i = 0; i < resLs.size(); i++) {
            res[i] = new int []{(int)resLs.get(i).getKey(), (int)resLs.get(i).getValue()};
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{3,4}};
        int[][] res =  new MergeIntervals().merge(a);
        System.out.println(res);
    }
}
