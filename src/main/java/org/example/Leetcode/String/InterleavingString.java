package org.example.Leetcode.String;

// https://leetcode.com/problems/interleaving-string/

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        return recursive(s1, s2, s3, 0,0);
    }
    public boolean recursive(String s1, String s2, String s3, int i, int j) {
        //System.out.println("i: "+i+"  j:"+j);
        if(i + j == s3.length()) {
            //System.out.println("FINAL   i: "+i+"  j:"+j);
            if(s1.length() == i && s2.length() == j) return true;
            else return false;
        }
        boolean tmpRes = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            tmpRes  = recursive(s1,s2, s3, i+1, j) == Boolean.TRUE? Boolean.TRUE : tmpRes;
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            tmpRes  = recursive(s1,s2, s3, i, j+1) == Boolean.TRUE? Boolean.TRUE : tmpRes;
        }

        return tmpRes;
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
