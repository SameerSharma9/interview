package org.example.Leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream()
                .mapToInt(a->a)
                .toArray();
    }
}
