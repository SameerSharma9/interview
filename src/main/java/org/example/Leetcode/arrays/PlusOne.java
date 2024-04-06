package org.example.Leetcode.arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlusOne {
    public int[] plusOne(int[] digits) {
//        LinkedList<Integer> list =  Arrays.asList(digits).stream()
//                .mapToInt(Integer::valueOf)
//                .collect(Collectors.toList());
        int i = digits.length;
        for(; i >= 0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i]+1;
                break;
            }
        }
        if(i == -1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else return digits;
    }
}
