package org.example.Leetcode.String;

// https://leetcode.com/problems/wildcard-matching/

import org.example.hackerrank.string.Pangrams;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class WildcardMatching {
    // s = aabcbac, p = a*c
    public boolean isMatch(String s, String p) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length();i++) {
            if(p.charAt(i) == '*') {
                int j = i+1;
                while(j<p.length()) {
                    if(p.charAt(j) == '*') {
                        i++;
                    } else break;
                    j++;
                }
            }
            sb.append(p.charAt(i));
        }
        boolean[][] dp = new boolean[s.length()+1][sb.length()+1];
        dp[0][0] = true;
        if(sb.length()>0 && sb.charAt(0) == '*') {
            dp[0][1] = true;
        }
        for(int i = 1; i < s.length()+1;i++) {
            for(int j = 1; j < sb.length()+1;j++) {
                if(s.charAt(i-1) == sb.charAt(j-1) || sb.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(sb.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
            }
        }
        return dp[s.length()][sb.length()];

    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("c", "*?*"));
    }
}
