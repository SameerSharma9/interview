package org.example.Leetcode.arrays;

// https://leetcode.com/problems/container-with-most-water/

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderElementImpl;
import oracle.jrockit.jfr.parser.FLREventInfo;

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

    public int maxArea2(int[] height) {
        int left = 0, right = height.length-1;
        int size = 0;
        while(left<right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            size = w*h > size ? w*h : size;
            if(height[left] < height[right]) left++;
            else right--;
        }
        return size;
    }

    public static void main(String[] args) {
        int res = new ContainerWithMostWater().maxArea(new int[]{8,7,2,1});
        int res2 = new ContainerWithMostWater().maxArea2(new int[]{8,7,2,1});
        System.out.println(res);
        System.out.println(res2);
    }
}