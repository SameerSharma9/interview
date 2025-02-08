package org.example.Leetcode.stack;

// https://leetcode.com/problems/longest-valid-parentheses/description/

import java.util.Stack;

public class LongestValidParantheses {
    //())()
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(len, max);
                }
            }
        }
        return max;
    }

    public int longestValidParenthesesWithOutStack(String s) {
        int open = 0;
        int close = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if(open == close) {
                int len = close * 2;
                max = Math.max(len,max);
            } else if (close>open) {
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if(open == close) {
                int len = open * 2;
                max = Math.max(len,max);
            } else if (close<open) {
                open = 0;
                close = 0;
            }
        }
        return max;
    }

    public int longestValidParenthesesDP(String s) {
        // TODO: Unimplemented DP method
        return 0;
    }


    public static void main(String[] args) {
        int res = new LongestValidParantheses().longestValidParentheses(")()())");
        System.out.println(res);
        int res2 = new LongestValidParantheses().longestValidParenthesesWithOutStack(")()())");
        System.out.println(res2);
    }
}
