package org.example.string;

// https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75

public class Compression {
    public int compress(char[] chars) {
        int current = 1, prev = 0;
        StringBuilder sb = new StringBuilder("");
        while(current < chars.length) {
            if (chars[current] != chars[prev] ) {
                sb.append(chars[prev]);
                if(current-prev > 1) {
                    sb.append(current-prev);
                }
                prev = current;
            }
            current++;
        }
        sb.append(chars[prev]);
        if(current-prev > 2) {
            sb.append(current-prev);
        }
        System.out.println(sb.toString());
        int i = 0;
        for(char c : sb.toString().toCharArray()) {
            chars[i] = c;
            i++;
        }
        return sb.length();
    }

    public static void main(String[] args) {
        int s = new Compression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','c'});
        System.out.println(s);
    }
}
