package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.HashMap;

public class LongestSubStringEvenVowels {
    public int findTheLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0,-1);
        int prefixSum = 0;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            prefixSum = prefixSum ^ getHash(c);
            if(indexMap.containsKey(prefixSum)) {
                maxLen = maxLen < (i - (indexMap.getOrDefault(prefixSum,0))) ? i - (indexMap.getOrDefault(prefixSum,0)) : maxLen;
            } else {
                indexMap.put(prefixSum,i);
            }


        }
        return maxLen;
    }

    private Integer getHash(Character c) {
        switch(c) {
            case 'a': return 1;
            case 'e': return 2;
            case 'i': return 4;
            case 'o': return 8;
            case 'u': return 16;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubStringEvenVowels().findTheLongestSubstring("bcbcbc"));
    }
}
