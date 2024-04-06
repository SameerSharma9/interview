package org.example.Leetcode.String;

//https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=programming-skills

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        System.out.println(sc.toString());
        System.out.println(tc.toString());
        return sc.toString().equals(tc.toString());
    }
}
