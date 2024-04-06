package org.example.hackerrank.array;

// https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-given-n-ranges/1?page=1&sortBy=submissions

import java.util.*;

public class KthSmallestElemInRanges {
    //O(nlogn+q*n)
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        Arrays.sort(range,Comparator.comparing(x-> x[0]));
        for(int j = 1;j < n; j++) {
            if(range[j][0] <= range[j-1][1]) {
                range[j][0] = range[j-1][1];
            }
            if(range[j][1] <= range[j-1][1]) {
                range[j][1] = range[j-1][1];
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i: queries) {
            int tmp = i;
            int j = 0;
            for(;j < n; j++) {
                if(j > 0 && range[j][0] == range[j][1] && range[j-1][1] == range[j][0]) continue;
                if(range[0][0] + i-1 < range[j][0]) {
                    res.add(-1);
                    break;
                }
                if(range[j][0]+tmp-1 <= range[j][1]) {
                    if(j > 0 && range[j-1][1] == range[j][0]) {
                        res.add(range[j][0]+tmp);
                    } else {
                        res.add(range[j][0]+tmp-1);
                    }

                    break;
                } else {
                    tmp = tmp - (range[j][1] - range[j][0] + 1);
                }
            }
            if(j == n && (range[0][0] + i-1 > range[j-1][1] || range[0][0] + i-1 < range[j-1][0])) {
                res.add(-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] range = new int[n][2];
        range[0] = new int[]{2,10};
        //range[1] = new int[]{6,8};
        range[1] = new int[]{9,10};
        range[2] = new int[]{5,13};
        range[3] = new int[]{5,12};
        int q = 3;
        int[] qu = new int[]{8,10,2};
        List<Integer> res = KthSmallestElemInRanges.kthSmallestNum(n,range,q,qu);
        System.out.println(res);

    }
}
