package org.example.Leetcode.arrays;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}
