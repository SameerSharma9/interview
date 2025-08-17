package org.example.Leetcode.dp;

// https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++) {
            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            for(int j = 0; j < res.get(i-1).size()-1;j++) {
                ls.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            ls.add(1);
            res.add(ls);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = new  PascalTriangle().generate(7);
        s.stream().peek(System.out::print).collect(Collectors.toList());
    }
}
