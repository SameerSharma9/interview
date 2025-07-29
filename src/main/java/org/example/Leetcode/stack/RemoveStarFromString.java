package org.example.Leetcode.stack;

// https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75

import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStarFromString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '*') {
                //if(stack.isEmpty()) throw Exception();
                stack.pop();
            } else stack.push(c);
        }
        LinkedList<Character> ls = new LinkedList<>();
        while(!stack.isEmpty()) ls.add(0, stack.pop());
        return ls.stream().map(String::valueOf).collect(Collectors.joining());

    }
}
