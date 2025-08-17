package org.example.interview;

import java.util.*;
import java.util.stream.Collectors;

public class VrizeR1 {
    public static void main(String[] args) {
        List<Employee> ls = new ArrayList<>();
        Map<Integer, List<Employee>> empMap = ls.stream().collect(Collectors.groupingBy(Employee::getDeptId));
        for(Map.Entry<Integer, List<Employee>> entry : empMap.entrySet()) {
            Employee e = entry.getValue().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .skip(1)
                    .findFirst().get();

            String s1 = "silent@";
            String s2 = "listen@";
            boolean res = new VrizeR1().isAnagram(s1, s2);
            System.out.println(res);
            //System.out.println((int)'@');

            String r1 = s1.chars().mapToObj(String::valueOf).sorted().collect(Collectors.joining());
            String r2 = s2.chars().mapToObj(String::valueOf).sorted().collect(Collectors.joining());
            System.out.println(r1.equals(r2));
        }

    }

    private boolean isAnagram(String s1, String s2) {
        int[] count = new int[256];
        Arrays.fill(count, 0);
        for (int i = 0; i < s1.length(); i++) {
            Character temp = s1.charAt(i);
            int a = (int) temp ;

            count[a]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            Character temp = s2.charAt(i);
            int a = (int) temp ;
            count[a]--;
        }
        for(int i: count) {
            if(i > 0) return false;
        }
        return true;

    }

}