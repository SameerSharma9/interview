package org.example.Leetcode.arrays;

// https://leetcode.com/problems/binary-subarrays-with-sum/description/?envType=daily-question&envId=2024-03-14

import java.util.HashMap;
import java.util.Map;

public class BinarySumArray {
    // 1,0,1,0,1
    // 1,0,0,0,1
    //0,0,0,0
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int tmpSum = 0;
        int i = 0, j = 0;
        for(; j < nums.length;j++){
            tmpSum += nums[j];
            if(tmpSum == goal) {
                res++;
                while(tmpSum == goal) {
                    tmpSum -= nums[i];
                    i++;
                }
            } else if(tmpSum > goal) {
                res++;
            }
        }
        for(; i < nums.length; i++){
            tmpSum -= nums[i];
            if(tmpSum == goal) {
                res++;
            } else if(tmpSum < goal) {
                break;
            }
        }
    return res;
    }

    //// 1,0,1,0,1
//    0-1
//    1-2
//    2-2
//    3-1
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int i = 0, j = 0, res = 0, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int n:nums) {
            prefix += n;
            res += map.getOrDefault(prefix - goal, 0);
            map.put(prefix, map.getOrDefault(prefix,0)+1);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySumArray().numSubarraysWithSum2(new int[]{0,0,0,0,0}, 0) );
    }
}
