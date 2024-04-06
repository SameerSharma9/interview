package org.example.dp1;

//https://leetcode.com/problems/delete-and-earn/description/

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Long> elem =  Arrays.stream(nums).boxed().collect(Collectors.toList()).stream().collect(Collectors.groupingBy(x->x, TreeMap<Integer, Long>::new, Collectors.counting()));
        List<Integer> distinctNums = Arrays.stream(nums).boxed()
                //.mapToInt(x->Integer.valueOf(x))
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));;
        long[] tmp = new long[distinctNums.size()];
        int i = 0;
        for(Map.Entry<Integer,Long> e:elem.entrySet()) {
            long t = e.getKey()*e.getValue();
            tmp[i] = t;
            int k = i-1;
            while(k >=0) {
                if(distinctNums.get(i) - 1 != distinctNums.get(k)) {
                    tmp[i] += tmp[k];
                    break;
                }
                k--;
            }

            if(i-1>=0 && tmp[i] < tmp[i-1]) {
                tmp[i] = tmp[i-1];
            }
            i++;
        }
        return (int)tmp[tmp.length-1];
    }
    public int deleteAndEarnLeetCodeSol(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = 0;
        for(int num:nums){
            if(num > max) max = num;
        }
        int[] dp = new int[max+1];
        for (int num:nums){
            dp[num] += num;
        }

        int prev1 = 0;
        int prev2 = 0;

        for (int value : dp) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + value, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


    public static void main(String[] args) {
        long res = new DeleteAndEarn().deleteAndEarnLeetCodeSol(new int[]{1,1,1,2,4,5,5,5,6});
        System.out.println(res);
    }
}
