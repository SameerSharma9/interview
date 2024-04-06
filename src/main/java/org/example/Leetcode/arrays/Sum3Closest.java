package org.example.Leetcode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int res = 0;

        for(int i = 0; i < nums.length-2;i++) {
//            if(i > 0 && nums[i] == nums[i - 1])
//                continue;
            int left = i+1, right = nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return target;
                if (Math.abs(sum-target) < closest) {
                    closest = Math.abs(sum-target);
                    res = sum;

//                    left++;
//                    right--;
                }
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        int res = new Sum3Closest().threeSumClosest(new int[]{-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1},-14);
        System.out.println(res);
    }
}
