package org.example.Leetcode.String;

// https://leetcode.com/problems/longest-palindromic-substring/description/

public class LongestPalindromSubstring {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character c: s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }
        s = sb.toString();
        int max = 1;
        int start = 0;
        int end = 0;
        for(int i = 1; i < s.length()-1; i++) {
            int tmpL = 1;
            int j = i-1;
            int k = i+1;
            while(j >= 0 && k < s.length()) {
                if(s.charAt(j) == s.charAt(k)) {
                    tmpL += 2;
                    j--;
                    k++;
                } else {
                    break;
                }


            }
            if(max <= tmpL) {
                max = tmpL;
                start = ++j;
                end = k;
            }
        }

        String sr =  s.replace("#","").substring(start/2,start/2+(int)Math.ceil(max/2d));
        if(sr.charAt(0) != sr.charAt(sr.length()-1)) {
            sr = sr.substring(0,sr.length()-1);
        }
        return sr;
    }

    public static void main(String[] args) {
        String s = new LongestPalindromSubstring().longestPalindrome("aacabdkacaa");
        System.out.println(s);
    }
}
