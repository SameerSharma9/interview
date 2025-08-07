package org.example.Leetcode.arrays;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/?envType=problem-list-v2&envId=greedy

public class SHortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;
        int i = 1, k = 0;
        for(; i < nums.length; ) {
            if(nums[i]==nums[k]) {
                i++;
            } else if(nums[i] < nums[k]) {
                break;
            } else {
                i++;
                k = i-1;
            }
        }
        int j = nums.length-2, l = j+1;
        for(; j >= 0; ) {
            if(nums[j]==nums[l]) {
                j--;
            } else if(nums[j] > nums[l]) {
                break;
            } else {
                j--;
                l = j+1;
            }
        }
        int min = nums[k];
        int max = nums[l];
        int p = k;
        int q = l;
        while(p<=l) {
            if(min > nums[p]) {
                min = nums[p];
            }
            p++;
        }
        while(q>=k) {
            if(max < nums[q]) {
                max = nums[q];
            }
            q--;
        }
        for(int r = 0; r < k; r++) {
            if(nums[r] > min) {
                k = r;
                break;
            }
        }
        for(int r = nums.length-1; r >= l; r--) {
            if(nums[r] < max) {
                l = r;
                break;
            }
        }
        if(min == max) return 0;
        return (l-k+1)<0?0:(l-k+1);
    }

    public static void main(String[] args) {
        int i = new SHortestUnsortedContinousSubarray().findUnsortedSubarray(new int[]{1,1,1});
        System.out.println(i);
    }
}
