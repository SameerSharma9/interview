package org.example.Leetcode.stack;

//https://leetcode.com/problems/daily-temperatures/description/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        //73,74,75,71,69,72,76,73
        //[1,1,4,2,1,1,0,0]
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.add(temperatures.length-1);
        res[temperatures.length-1] = 0;
        for(int i = temperatures.length-2; i > -1; i--) {
            if(temperatures[i] >= temperatures[stack.peek()]) {
                while(stack.size() != 0 && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if(stack.size() == 0) {
                    res[i] = 0;
                } else {
                    res[i] = stack.peek() - i;
                }
            } else {
                res[i] = 1;
            }
            stack.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperature test = new DailyTemperature();
        int[] res = test.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        for(int a:res) {
            System.out.println(a);
        }
    }
                      //[8,1,5,4,3,2,1,1,0,0]
}
