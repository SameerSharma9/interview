package org.example.Leetcode;

import java.util.*;
import java.util.regex.Pattern;

class WordDictionary {
    Map<Integer, Set<String>> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        Set<String> set = map.getOrDefault(len, new TreeSet<>());
        set.add(word);
        map.put(len, set);
    }

    public boolean search(String word) {
        int len = word.length();
        if(!map.containsKey(len)) return false;
        Set<String> set = map.get(len);
        if(word.indexOf('.') == -1) {
            return set.contains(word);
        } else {
            int start = word.indexOf('.');
            int end = word.lastIndexOf('.');
            Pattern p = Pattern.compile(word,Pattern.CASE_INSENSITIVE);

            return set.stream().filter(x->p.matcher(x).matches()).findFirst().isPresent();
        }
    }
}