package org.example.dp1;

//https://leetcode.com/problems/house-robber/description/

import java.util.Arrays;
import java.util.Comparator;

public class HouseRobber {

    //2,7,9,3,1 --> 12
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int val : nums) {
            int temp = prev1;
            prev1 = Math.max(val+prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int price = new HouseRobber().rob(new int[]{2,7,9,3,1});
        System.out.println(price);
    }
}
