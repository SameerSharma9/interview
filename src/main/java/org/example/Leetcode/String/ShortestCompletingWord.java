package org.example.Leetcode.String;

import org.example.Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/shortest-completing-word/description/
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Long> map = licensePlate.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .filter( x-> Character.isAlphabetic(x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String res = null;
        int len = Integer.MAX_VALUE;
        for(String word:words) {
            Map<Character, Long> mapTemp = word.chars()
                    .mapToObj(c -> (char) c)
                    .filter( x-> Character.isAlphabetic(x))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            boolean flag = true;
            for(Map.Entry entry:map.entrySet()) {
                if(!mapTemp.containsKey(entry.getKey())
                        || mapTemp.get(entry.getKey()) < (Long)entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            if(flag && word.length() < len){
                res = word;
                len = word.length();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String word = new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"});
        String word2 = new ShortestCompletingWord().shortestCompletingWord("1s3 456", new String[]{"looks","pest","stew","show"});
        System.out.println(word);
        System.out.println(word2);
    }
}
