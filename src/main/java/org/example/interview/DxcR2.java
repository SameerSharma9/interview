package org.example.interview;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DxcR2 {
    public static void main(String... args) {
        Object a = "abc";
        Object b = "abc";
        System.out.println(a==b);
        String c  ="abc";
        x(c);
        System.out.println(a);
    }

    private static void x(String a) {
        a = "xyz";
    }


//    private Map<String, Integer> readFileAndReturnGroupingCount() {
//        File f = new File("/");
//        BufferedReader bf = new BufferedReader(new FileReader(f));
//        Map<String, Integer> resMap = new TreeMap<>();
//        try {
//            if(bf.ready()) {
//                String[] line = bf.readLine().split(" ");
//                if(line == null) return resMap;
//                StringBuilder sb = new StringBuilder(line[0]);
//                sb.append("-").append(line[1]);
//                if(resMap.containsKey(sb.toString()))  {
//                    resMap.put(sb.toString(), resMap.get(sb.toString())+1);
//                } else {
//                    resMap.put(sb.toString(), 1);
//                }
//
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return resMap;
//
//    }
}

/*

select concat(name, xmic_code), dense_rank (partition by name) count_of_occr
from table transaction
group by name, xmic_code
order by name asc, xmic_code asc , count_of_occr desc

 */
