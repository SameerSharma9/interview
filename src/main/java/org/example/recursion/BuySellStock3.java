package org.example.recursion;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        return calPrice(0, true, prices, 2);
    }

    private int calPrice(int idx, boolean buy, int[] prices, int txn) {
        if(txn<= 0 || idx >= prices.length) return 0;
        if(buy) {
            return Math.max(-prices[idx] + calPrice(idx+1, false, prices, txn),
                    0 + calPrice(idx+1, buy, prices, txn));
        }
        return Math.max(prices[idx] + calPrice(idx+1, true, prices, txn-1),
                0 + calPrice(idx+1, buy, prices, txn));

    }
}
