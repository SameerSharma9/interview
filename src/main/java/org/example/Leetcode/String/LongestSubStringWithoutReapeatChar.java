package org.example.Leetcode.String;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubStringWithoutReapeatChar {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int a = (int)'a';
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int v = map.get(s.charAt(i));
                v -= start;
                start = map.get(s.charAt(i)) + 1;
                Iterator it = map.entrySet().iterator();
                while(v>=0) {
                    it.next();
                    it.remove();
                    v--;
                }
            }
            map.put(s.charAt(i), i);
            if( max < (i - start) + 1) {
                max = (i - start) + 1;
            }


        }
        map.entrySet().stream().peek(System.out::println).collect(Collectors.toList());
        return max;
    }

    public static void main(String[] args) {
        int s = new LongestSubStringWithoutReapeatChar().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(s);
    }
}
