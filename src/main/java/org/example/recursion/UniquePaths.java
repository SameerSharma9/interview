package org.example.recursion;

// https://leetcode.com/problems/unique-paths/description/

import java.util.Date;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return getCount(m, n, 0, 0);
    }

    private int getCount(int m, int n, int indexRow, int indexCol) {
        if(indexRow == m-1 && indexCol == n-1) {
            return 1;
        }
        int count = 0;
        if(indexRow < m-1) {
            count += getCount(m, n, indexRow+1, indexCol);
        }
        if(indexCol < n-1) {
            count += getCount(m, n, indexRow, indexCol+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new UniquePaths().uniquePaths(25,9));
        System.out.println(new Date());
    }
}
