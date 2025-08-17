package org.example.recursion;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/?envType=problem-list-v2&envId=dynamic-programming

import java.util.Arrays;

public class BuySellStockWIthCooldown {
    /*
    Input: prices = [1,2,3,0,2]
Output: 3
     */
    public int maxProfit(int[] prices) {
        return calPrice(0, true, prices);
    }

    private int calPrice(int idx, boolean buy, int[] prices) {
        if(idx >= prices.length) return 0;
        if(buy) {
            return Math.max(-prices[idx] + calPrice(idx+1, false, prices),
                    0 + calPrice(idx+1, buy, prices));
        }
        return Math.max(prices[idx] + calPrice(idx+2, true, prices),
                0 + calPrice(idx+1, buy, prices));

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,20};
        System.out.println(new BuySellStockWIthCooldown().calPrice(0, true, arr));
    }
}
