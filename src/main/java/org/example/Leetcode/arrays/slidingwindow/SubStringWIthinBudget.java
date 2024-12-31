package org.example.Leetcode.arrays.slidingwindow;

// https://leetcode.com/problems/get-equal-substrings-within-budget/?envType=problem-list-v2&envId=prefix-sum

public class SubStringWIthinBudget  {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diffArr = new int[s.length()];
        int window = maxCost;
        int result = 0;
        int tmpLen = 0;
        for(int i = 0; i < s.length();i++) {
            diffArr[i] = Math.abs((int)s.charAt(i) - (int)t.charAt(i));
        }
        for(int i = 0, j = 0; j < diffArr.length; j++) {
            if(diffArr[j] != 0) {
                while(diffArr[j] > window && i <= j) {

                    if(window + diffArr[i] <= maxCost) {
                        window += diffArr[i];
                        tmpLen--;
                    }
                    i++;
                }
            }
            if(i > j) continue;
            window -= diffArr[j];
            tmpLen++;
            result = tmpLen > result ? tmpLen : result;


        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SubStringWIthinBudget().equalSubstring("anryddgaqpjdw", "zjhotgdlmadcf", 5));
    }
}
