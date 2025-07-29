package org.example.Leetcode.arrays;

//https://leetcode.com/problems/word-break/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println( wordBreak("abcd", Arrays.asList("a","abc","b","cd")) );
    }

    /*
    Input: s = "leetcod", wordDict = ["leet","cod"]
    Output: true
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dic = new HashSet<>(wordDict);
        int mLen = wordDict.stream().mapToInt(x->x.length()).max().getAsInt();
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = Boolean.TRUE;
        for(int i = 1; i <= s.length(); i++)  {
            for(int j = i-1; i-j <= mLen; j--) {
                if(j < 0) break;
                String tmp = s.substring(j,i);
                if(dic.contains(tmp)) {
                    if(j >= 1 && dp[j] == false) dp[i] = false;
                    else {
                        dp[i] = Boolean.TRUE;
                        break;
                    }
                } else {
                    dp[i] = false;
                }
            }
        }
        for(boolean b: dp) {
            System.out.println(b);
        }
        return dp[dp.length-1];

    }
}
