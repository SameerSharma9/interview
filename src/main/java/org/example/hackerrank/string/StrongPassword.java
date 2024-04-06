package org.example.hackerrank.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StrongPassword {

    public static void main(String[] args) {
        System.out.println(minimumNumber(3,"790"));
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        if(password == null) return 6;
        int res = 0;
        if(!containsLowerCase(password)) res++;
        if(!containsUperCase(password)) res++;
        if(!containsNumber(password)) res++;
        if(!containsSpl(password)) res++;
        if(n>6) return res;
        else if(6-n > res) return 6-n;
        else return res;

    }

    private static boolean containsLowerCase(String pass) {
        int a = (int)'a';
        int z = (int)'z';
        Optional<Integer> tmp = pass.chars().mapToObj(Integer::valueOf).filter(x-> x>=a && x<=z).findFirst();
        return tmp.isPresent();
    }

    private static boolean containsUperCase(String pass) {
        int a = (int)'A';
        int z = (int)'Z';
        Optional<Integer> tmp = pass.chars().mapToObj(Integer::valueOf).filter(x-> x>=a && x<=z).findFirst();
        return tmp.isPresent();
    }

    private static boolean containsNumber(String pass) {
        int a = (int)'0';
        int z = (int)'9';
        Optional<Integer> tmp = pass.chars().mapToObj(Integer::valueOf).filter(x-> x>=a && x<=z).findFirst();
        return tmp.isPresent();
    }

    private static boolean containsSpl(String pass) {
        Set<Character> splChar = "!@#$%^&*()-+".chars().mapToObj(i -> (char)i).collect(Collectors.toSet());
        Optional<Character> tmp = pass.chars().mapToObj(i -> (char)i).filter(x->splChar.contains(x)).findFirst();
        return tmp.isPresent();
    }
}
