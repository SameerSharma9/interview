package org.example.Leetcode.arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSortedArray {
    // 1 3 4 6 7 8
    // 2 5 9 10
    // 1 3 4  6 7 8
    // 2 5    9 10
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int lo = 0;
        int hi = nums1.length;
        int c1;
        int c2;
        while(lo <= hi) {
            c1 = (lo + hi)/2;
            c2 = (nums1.length + nums2.length + 1)/2 - c1;
            int l1 = c1 == 0? Integer.MIN_VALUE:nums1[c1-1];
            int l2 = c2 == 0? Integer.MIN_VALUE:nums2[c2-1];
            int r1 = c1 == nums1.length? Integer.MAX_VALUE:nums1[c1];
            int r2 = c2 == nums2.length? Integer.MAX_VALUE:nums2[c2];

            if(l1 > r2) {
                hi = c1 - 1;
            } else if(l2 > r1) {
                lo = c1 + 1;
            } else {
                if((nums1.length + nums2.length)%2 == 0) {
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                } else {
                    return Math.max(l1,l2);
                }
            }
        }
        return 0d;

    }
}
