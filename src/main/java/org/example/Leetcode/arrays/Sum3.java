package org.example.Leetcode.arrays;

// https://leetcode.com/problems/3sum/description/

import java.util.*;
import java.util.stream.Collectors;

public class Sum3 {
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length-2;i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i+1, right = nums.length-1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[left]);
                    r.add(nums[right]);
                    res.add(r);
                    while(left < right && nums[left + 1] == nums[left])
                        left++;
                    while(left < right && nums[right - 1] == nums[right])
                        right--;
                    left++;
                    right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        new Sum3().threeSum(new int[]{1,0,-1}).stream().peek(System.out::println).collect(Collectors.toList());
    }
}
