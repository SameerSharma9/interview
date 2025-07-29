package org.example.Leetcode.stack;

//https://leetcode.com/problems/daily-temperatures/description/

import javafx.util.Pair;

import java.util.*;

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

    public int[] dailyTemperatures2(int[] temperatures) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures[0]);
        map.put(temperatures[0], 0);
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        for (int i = 1; i < temperatures.length; i++) {
            while(!stack.empty() && temperatures[i] > stack.peek()) {
                res[map.get(stack.peek())] = i - map.get(stack.pop());
            }
            stack.push(temperatures[i]);
            map.put(temperatures[i], i);
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
