package org.example.Leetcode.arrays.slidingwindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=problem-list-v2&envId=prefix-sum

public class MaxConsecutiveOneV3 {
    public int longestOnes(int[] nums, int k) {
        int window = k;
        int res = 0;
        int tmpLen = 0;
        for(int i = 0, j = 0; j < nums.length; j++) {
            if(nums[j] == 0)
            while(window == 0 && i <= j) {
                if(nums[i] == 0) {
                    window++;
                }
                tmpLen--;
                i++;
            }
            tmpLen++;
            if(nums[j] == 0) window--;
            if(res < tmpLen) res = tmpLen;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOneV3().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
