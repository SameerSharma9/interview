package org.example.Leetcode.String;

//https://leetcode.com/problems/remove-duplicate-letters/?envType=problem-list-v2&envId=stack

import java.nio.charset.CharsetEncoder;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    //z s d b c a b d b c
    // Output: zsabdc

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Integer[] lastIndex = new Integer[26];
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int i = 0;
        for(Character c : s.toCharArray()) {
            if(set.contains(c)) {
                i++;
                continue;
            }
            while(!stack.isEmpty() && (stack.peek() > c && lastIndex[stack.peek() - 'a'] > i)) {
                set.remove(stack.pop());
            }

            stack.push(c);
            set.add(c);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(x->sb.append(x));
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String result = removeDuplicateLetters.removeDuplicateLetters("abacb");
        System.out.println(result); // Output: zsabdc
    }
}
