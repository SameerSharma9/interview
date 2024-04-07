package org.example.Leetcode.math;

// https://leetcode.com/problems/gray-code/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> tmp = new ArrayList<>();

        if(n >= 1) {
            tmp.add("0");
            tmp.add("1");
        }
        for(int i = 2; i <= n; i++) {
            List<String> newTmp = new ArrayList<>();
            int size = tmp.size();
            for(int j = 0; j < size; j++) {
                newTmp.add("0"+tmp.get(j));
            }
            for(int j = size-1; j >=0 ; j--) {
                newTmp.add( "1"+tmp.get(j));
            }
            tmp = newTmp;
        }
        return tmp.stream().map(x->Integer.parseInt(x,2)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3));
    }
}
