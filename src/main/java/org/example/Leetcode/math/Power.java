package org.example.Leetcode.math;

// https://leetcode.com/problems/powx-n/

import java.math.BigDecimal;

public class Power {
    public double myPow(double x, int n) {

        if(n == 0) return 1d;
        long N = n;

        if(N < 0) {
            x = 1/x;
            N *= -1;
        }
            return n%2 == 0?myPow(x*x, (int)N/2):x*myPow(x*x, (int)N/2);
    }

    public static void main(String[] args) {
        new Power().myPow(2d,10);
    }
}
