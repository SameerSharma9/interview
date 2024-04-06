package org.example.Leetcode.arrays;

// https://leetcode.com/problems/container-with-most-water/

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderElementImpl;

import java.util.Arrays;
import java.util.Comparator;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int[] cap = new int[height.length];
        int res = 0;
        for(int i = 0, j = height.length-1; i < j;) {
            int min = Math.min(height[i],height[j]);
            int x = min == height[i]?i:j;
            cap[x] = min * (j-i);
            res = res>cap[x]?res:cap[x];
            if(x == i) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(res);
    }
}