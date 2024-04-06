package org.example.hackerrank.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
}

// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        int[] tmp = new int[nums2.length];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(tmp, -1);
        stk.add(nums2[nums2.length-1]);
        map.put(nums2[nums2.length-1], -1);
        for(int i = nums2.length - 2; i>=0; i--) {
            if(nums2[i] < stk.peek()) {
                map.put(nums2[i], stk.peek());
                stk.add(nums2[i]);
            } else {
                while(!stk.isEmpty() && nums2[i] > stk.peek()) {
                    stk.pop();
                }
                if(stk.isEmpty()) {
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], stk.peek());
                }
                stk.add(nums2[i]);
            }
        }
        System.out.println(map);
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }


        return res;
    }
}
/*
start from right of num2 and keep decrementing counter;
insert rightmost into stack;
if i < stack.peek
    insert into map;
    add num2[i] to stack;
 else
    pop from stack;
    check again until stack is not empty;
        if stack empty
            add num2[i] to stack and mark -1 against in the map;

 */