package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/random-pick-with-weight/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeights {
    int[] prefixSum;
    Random rand;
    public RandomPickWithWeights(int[] w) {
        rand = new Random();
        prefixSum = new int[w.length];
        Arrays.fill(prefixSum,0);
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int num = rand.nextInt(prefixSum[prefixSum.length-1]+1);
        //System.out.println(num);
        int i = 0, j = prefixSum.length-1;
        if(i == j) return 0;
        while(i<j) {
            int median = i+(j-i)/2;
            if(num == prefixSum[median]) return median;
            else if(num > prefixSum[median]){
                i = median+1;
            } else {
                j = median;
            }
        }
        return i;
    }
}
