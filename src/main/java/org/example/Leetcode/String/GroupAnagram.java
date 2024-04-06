package org.example.Leetcode.String;

// https://leetcode.com/problems/group-anagrams/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s:strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sum = String.valueOf(arr);
            map.putIfAbsent(sum,new ArrayList<>());
            map.get(sum).add(s);
        }
        for(String entry:map.keySet()) {
            res.add(map.get(entry));
        }
        return res;
    }
}
