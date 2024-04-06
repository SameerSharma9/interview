package org.example.Leetcode.arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums[0] == 0) {
            nums[0] = nums[1];
            nums[1] = 0;
        }
        for(int i = 1, j = 1; j < nums.length; ) {
            if(nums[j] > 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                j++;
                i++;
            } else {
                j++;
            }
        }
    }
}
