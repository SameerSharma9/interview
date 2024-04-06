package org.example.Leetcode.String;

public class ReverseInteger {
    public int reverse(int x) {
        if(x> Integer.MAX_VALUE) return 0;
        char[] temp = Integer.valueOf(x).toString().toCharArray();
        int i = 0;
        int j = temp.length -1;
        if(temp[0] == '-') {
            i = 1;
        }
        for(; j > -1; j--) {
            if (temp[j] != '0') break;
        }
        int z = j;
        while(i<j) {
            char t = temp[i];
            temp[i] = temp[j];
            temp[j] = t;
            i++;
            j--;
        }
        return new Integer(String.copyValueOf(temp).substring(0,z+1));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(964632435));
    }
}
