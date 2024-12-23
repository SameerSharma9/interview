package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/shifting-letters/?envType=problem-list-v2&envId=prefix-sum

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        long[] preSum = new long[shifts.length];
        preSum[shifts.length-1] = shifts[shifts.length-1];
        for(int i = shifts.length-2; i >= 0; i--) {
            preSum[i] = preSum[i+1] + shifts[i];
        }
        for(int i = 0; i < shifts.length; i++) {
            preSum[i] %= 26;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Character c : s.toCharArray()) {
            int tmp = (int)c - (int)'a' + (int)preSum[i];

            sb.append((char)((int)'a' + tmp%26));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        System.out.println(new ShiftingLetters().shiftingLetters("mkgfzkkuxownxvfvxasy",arr));
    }
}
