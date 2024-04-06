package org.example.hackerrank.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WeightedUniformString {

    public static void main(String[] args) {
        System.out.println(WeightedUniformString.weightedUniformStrings("abccddde", Arrays.asList(6,1,3,12,5,9,10)));
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        HashSet<Integer> posComb = new HashSet<>();

        for(int i = 0, res = 0; i < s.length(); i++) {
            int alphVal = (int)s.charAt(i) - (int)'a' + 1;
            res += alphVal;
            posComb.add(res);
            if(i < s.length()-1 && s.charAt(i) != s.charAt(i+1)) {
                res = 0;
            }
        }
        return queries.stream().map(x-> {
            if(posComb.contains(x)) {
                return "Yes";
            }
            else return "No";
        }).collect(Collectors.toList());

    }
}
