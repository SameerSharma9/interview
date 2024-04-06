package org.example.string;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

import java.util.Arrays;

public class NextGreatestChar {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] c = new int[((int)'z')+1];
        Arrays.fill(c,0);
        for(char l: letters) {
            c[(int)l] = 1;
        }
        for(int i = ((int) target)+1; i < c.length; i++) {
            if(c[i] == 1) return (char)i;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char c = new NextGreatestChar().nextGreatestLetter(new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},'a');
        System.out.println(c);
    }
}
