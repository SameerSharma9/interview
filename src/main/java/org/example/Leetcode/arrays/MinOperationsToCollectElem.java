package org.example.Leetcode.arrays;

// https://leetcode.com/problems/minimum-operations-to-collect-elements/

import java.util.List;

public class MinOperationsToCollectElem {
    //nums = [3,1,5,4,2], k = 2
    public int minOperations(List<Integer> nums, int k) {
        int[] collected = new int[k+1];
        int count = 0;
        for(int i = nums.size()-1;i>=0;i--) {
            if(count == k) return nums.size() - i+1;
            if(nums.get(i) <= k && collected[nums.get(i)] == 0 ) {
                count++;
                collected[nums.get(i)] = i;
            }
        }
        return nums.size();
    }
}
