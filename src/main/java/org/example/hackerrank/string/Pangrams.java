package org.example.hackerrank.string;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Pangrams {

    public static void main(String[] args) {
        System.out.println(Pangrams.pangrams("We promptly judged antique ivory buckles for the next prize"));
    }

    public static String pangrams(String s) {
        List<Character> sortedList = s.chars().mapToObj(x-> (char)x).map(Character::toLowerCase).sorted().distinct().collect(Collectors.toList());

        Iterator<Character> itr = sortedList.iterator();
        int low = (int)'a';
        int high = (int)'z';
        int tmp = low;
        while(itr.hasNext()) {
            Character nxt = itr.next();
            if((int)nxt < low || (int)nxt > high) continue;
            if((int)nxt != tmp) {
                return "not pangram";
            }
            tmp++;
        }
        if(--tmp  == high)
        return "pangram";
        else return "not pangram";

    }
}
