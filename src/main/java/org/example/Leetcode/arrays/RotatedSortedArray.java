package org.example.Leetcode.arrays;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

import lombok.val;

public class RotatedSortedArray {
    // [4,5,6,7,0,1,2]
    //7,1,2,3,4,5,6
    public int search(int[] nums, int target) {
        int b = 0;
        int e = nums.length;
        int pivot = nums.length-1;
        if(nums.length == 1) {
            return nums[0] == target?0:-1;
        }
        if(nums.length == 2) {
            return nums[0] == target?0:nums[1] == target?1:-1;
        }
        if(nums[0] > nums[nums.length-1]) {
            pivot = getFirst(b,e,nums,target);
            if(nums[nums.length-1] >= target) {
                b = pivot;
            } else {
                e = pivot-1;
            }
        }
        if(nums[pivot] == target) return pivot;


        while(e>=b && b != nums.length) {
            pivot = (e+b)/2;
            if(target == nums[pivot]) return pivot;

            if(nums[pivot] < target) {
                b = pivot+1;
            } else {
                e = pivot-1;
            }
        }
        return -1;

    }

    private int getFirst(int b,int e, int[] nums, int target) {
        if(b >= e ) return -1;

        int pivot = (e+b)/2;
        if(nums[pivot] == target) return pivot;
        if(pivot == 0) return -1;
        if(pivot == nums.length-1) return nums.length-1;
        if(nums[pivot-1] > nums[pivot] && nums[pivot] < nums[pivot+1]) {
            return pivot;
        }
        if(nums[pivot-1] < nums[pivot] && nums[pivot] > nums[pivot+1]) {
            return ++pivot;
        }
       int left =  getFirst(b,pivot, nums,target) ;
       int right = getFirst(pivot+1, e, nums,target);
       return left != -1? left:right;
    }

    public static void main(String[] args) {
        int res = new RotatedSortedArray().search(new int[]{2,3,5,7,1}, 6);
        System.out.println(res);
    }
}
