package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Interview {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(4,1,3,5,8,2);
        int k = 3;
        System.out.println(new Interview().kLarge(arr,k));
    }
    public int kLarge(List<Integer> ls, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer i : ls) {
            minHeap.add(i);
            if (minHeap.size() > K)
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
