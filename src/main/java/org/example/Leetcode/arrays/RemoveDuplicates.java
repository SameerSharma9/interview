package org.example.Leetcode.arrays;

public class RemoveDuplicates {

    //[0,0,1,1,1,2,2,3,3,4]
    //[0,1,1,1,1,2,2,3,3,4]
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int j = i + 1; j < nums.length; ) {
                if (nums[i] != nums[j]) {
                    if (j - i != 1) {
                        nums[i + 1] = nums[j];
                    }
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            return i;
        }
}

