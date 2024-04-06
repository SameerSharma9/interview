package org.example.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeated {
    public static void main(String args[]) {
    String input = "Java articles are Awesome";

    Character result = input.chars() // Stream of String
            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1L)
            .map(entry -> entry.getKey())
            .findFirst()
            .get();
    System.out.println(result);

        Map<Character, Long> result2 = input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .filter(s -> !s.equals(' '))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));
        System.out.println(result2);
        //{ =3, a=5, c=1, e=4, i=1, j=1, l=1, m=1, o=1, r=2, s=2, t=1, v=1, w=1}
        //{a=5, e=4,  =3, r=2, s=2, j=1, v=1, t=1, i=1, c=1, l=1, w=1, o=1, m=1}
}
}

