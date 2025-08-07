package org.example.Leetcode.stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s:tokens) {
            switch(s) {
                case "+": {
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    s = String.valueOf(a + b);
                    stack.push(s);
                    break;
                }
                case "-": {
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    s = String.valueOf(b-a);
                    stack.push(s);
                    break;
                }
                case "/": {
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    s = String.valueOf(b/a);
                    stack.push(s);
                    break;
                }
                case "*": {
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    s = String.valueOf(a * b);
                    stack.push(s);
                    break;
                }
                default: stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}