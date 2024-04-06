package org.example.hackerrank.string;

import java.util.Stack;

//https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true
public class ReducedString {
    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
    }

    public static String superReducedString(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            stk.add(s.charAt(i));
            sb.append(s.charAt(i));
            if(stk.size() > 1) {
                char top = stk.pop();
                char sec = stk.pop();
                if(top != sec) {
                    stk.add(sec);
                    stk.add(top);
                } else {
                    sb.delete(sb.length()-2, sb.length());
                }
            }
            i++;
        }
        return sb.toString().equals("")? "Empty String":sb.toString();
    }

}
