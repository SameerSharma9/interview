package org.example.Leetcode.String;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CloseString {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Long> s1Map = word1.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        Map<Character, Long> s2Map = word2.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        boolean res = true;
        List<Character> mismatch = new ArrayList<>();
        if(!s1Map.keySet().equals(s2Map.keySet())) return false;
        if(!s1Map.values().stream().sorted().collect(Collectors.toList()).equals(s2Map.values().stream().sorted().collect(Collectors.toList()))) return false;
        return true;
    }
}
