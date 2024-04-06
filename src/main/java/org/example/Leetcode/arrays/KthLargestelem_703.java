package org.example.Leetcode.arrays;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class KthLargest {

    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        for (int n : nums) add(n);
        this.k = k;
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}