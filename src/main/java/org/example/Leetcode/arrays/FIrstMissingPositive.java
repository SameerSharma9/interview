package org.example.Leetcode.arrays;

// https://leetcode.com/problems/first-missing-positive/description/

public class FIrstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }
        for(int i = 0; i < nums.length; ) {
            if(nums[i] == 0 || i == nums[i] -1) {
                i++;
                continue;
            }

            int val = nums[i];
            int tmp = nums[val-1];
            if(val == tmp) {
                nums[i] = 0;
                i++;
                continue;
            }
            nums[val-1] = val;
            nums[i] = tmp;

        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
