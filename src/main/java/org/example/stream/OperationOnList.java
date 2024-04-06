package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationOnList {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
