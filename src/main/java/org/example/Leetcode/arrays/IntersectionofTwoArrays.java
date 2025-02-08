package org.example.Leetcode.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays {
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        l1.retainAll(l2);
        l1 = l1.stream().distinct().collect(Collectors.toList());
        return l1.stream()
                .mapToInt(a->a)
                .toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return res.stream()
                .mapToInt(a->a)
                .toArray();
    }
}
