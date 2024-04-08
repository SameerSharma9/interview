package org.example.Leetcode.String;

// https://leetcode.com/problems/decode-ways/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DecodeWays {
    HashMap<String, Integer> map = new HashMap<>();
    public int numDecodings(String s){
        if(map.containsKey(s)) return map.get(s);
        if(s.startsWith("0")) return 0;
        if(s.equals("") || s.length() == 1) return 1;
        if(s.length() == 2 && (Integer.parseInt(s.substring(1,2))  == 0 && Integer.parseInt(s.substring(0,1)) > 2)) return 0;
        if(s.length() == 2 && (Integer.parseInt(s.substring(0,1)) > 2 && Integer.parseInt(s.substring(1)) > 6)) return 1;

        System.out.println(s);
        int s1 =  numDecodings(s.substring(1));
        int s2 = (s.length() > 1 && Integer.parseInt(s.substring(0,2)) < 27 ? numDecodings(s.substring(2)):0);

        map.put(s, s1+s2);
        return  s1+s2 ;
    }



    public static void main(String[] args) {
        int s = new DecodeWays().numDecodings("17");
        System.out.println(s);
    }
}
