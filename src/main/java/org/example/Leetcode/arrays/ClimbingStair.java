package org.example.Leetcode.arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class ClimbingStair {

    //1,100,1,1,1,100,1,1,100,1
    //2,15,14
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length+1];
        //res[0] = cost[0];
        //res[1] = cost[1];
        for(int i = 2; i <= cost.length; i++) {
            //res[i] = Math.min(cost[i] + res[i-2], res[i-1]);
             res[i] = Math.min(res[i-2] + cost[i-2], res[i-1] + cost[i-1]);
        }
        return res[cost.length];
    }

    public static void main(String[] args) {
        int res = new ClimbingStair().minCostClimbingStairs(new int[]{2,15,14});
        System.out.println(res);

    }
}
