package org.example.Leetcode.arrays;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
public class MaxProfit {

    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0, j = i+1;
        for(; j < prices.length; ) {
            if(prices[j-1] > prices[j]) {
                profit += prices[j-1] - prices[i];
                i=j;
                j = i+1;
            } else {
                j++;
            }
        }
        if(j-i > 1) {
            profit += prices[j-1] - prices[i];
        }
        return profit;
    }
}
