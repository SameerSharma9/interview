package org.example.Leetcode.String;

// https://leetcode.com/problems/interleaving-string/

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Set<Integer> visited = new HashSet<>();

        for(int i = 0, j = 0; i < s1.length() && j < s3.length();j++) {
            if(s1.charAt(i) == s3.charAt(j)) {
                visited.add(j);
                i++;
            }
        }
        for(int i = 0, j = 0; i < s2.length() && j < s3.length();j++) {
            if(s2.charAt(i) == s3.charAt(j) && !visited.contains(j)) {
                visited.add(j);
                i++;
            }
        }
        if(visited.size() == s1.length() + s2.length()) {
            return true;
        }
        visited.clear();
        for(int i = 0, j = 0; i < s2.length() && j < s3.length();j++) {
            if(s2.charAt(i) == s3.charAt(j)) {
                visited.add(j);
                i++;
            }
        }
        for(int i = 0, j = 0; i < s1.length() && j < s3.length();j++) {
            if(s1.charAt(i) == s3.charAt(j) && !visited.contains(j)) {
                visited.add(j);
                i++;
            }
        }
        if(visited.size() == s1.length() + s2.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
