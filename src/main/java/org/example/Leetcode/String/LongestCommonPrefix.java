package org.example.Leetcode.String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int w = 1;
        String tmp = strs[0];
        while(w -1 < tmp.length()){
            w++;
            for(String s: strs) {
                if(w - 1 > s.length())  return tmp.substring(0,w-2);

                if(!s.startsWith(tmp.substring(0,w-1))) {
                    return tmp.substring(0,w-2);
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"ab", "a"};
        String ss = new LongestCommonPrefix().longestCommonPrefix(s);
        System.out.println(ss);
    }
}
