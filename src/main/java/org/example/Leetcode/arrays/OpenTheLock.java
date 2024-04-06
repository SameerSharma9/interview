package org.example.Leetcode.arrays;

// https://leetcode.com/problems/open-the-lock/

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        StringBuilder sb = new StringBuilder("0000");
        for(int i = 0; i < 4; i++) {
            int val = Integer.valueOf(target.charAt(i));
            boolean rev = false;
            if(val >= 5) {
                rev = true;
            }
            ///while()
        }
        return 0;
    }
}
