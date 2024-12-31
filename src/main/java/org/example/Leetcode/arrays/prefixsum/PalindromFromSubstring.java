package org.example.Leetcode.arrays.prefixsum;

//https://leetcode.com/problems/can-make-palindrome-from-substring/description/?envType=problem-list-v2&envId=prefix-sum

import java.util.ArrayList;
import java.util.List;

public class PalindromFromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> resultList = new ArrayList<>();
        int[][] prefixSum = new int[26][s.length()+1];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (int)c - (int)'a';
            prefixSum[idx][i+1] = 1;
            for(int j = 0; j < 26; j++) {
                prefixSum[j][i+1] += prefixSum[j][i] ;
            }
        }

        for(int[] query : queries) {
            int countOdd = 0;
            for(int k = 0; k < 26; k++) {
                if ((prefixSum[k][query[1]+1] - prefixSum[k][query[0]]) % 2 == 1) {
                    countOdd++;
                }
            }
            if(countOdd == 0 || s.length() % 2 == 1 && countOdd == 1 || query[2] >= countOdd/2) resultList.add(Boolean.TRUE);
            else resultList.add(Boolean.FALSE);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][3];
        arr[0]=new int[]{3,3,0};
        arr[1]=new int[]{1,2,0};
        arr[2]=new int[]{0,3,1};
        arr[3]=new int[]{0,3,2};
        arr[4]=new int[]{0,4,1};
        System.out.println(new PalindromFromSubstring().canMakePaliQueries("abcda", arr));
    }
}
