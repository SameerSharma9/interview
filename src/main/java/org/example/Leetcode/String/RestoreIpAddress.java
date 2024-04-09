package org.example.Leetcode.String;

// https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        getIPs(s,0,3);
        return res;
    }

    private void getIPs(String s, int index, int dots) {

        if(dots == 0) {
            String t = s.substring(index);
            if(t.length() <= 0) return;
            if(Integer.parseInt(t)>255) return;
            if(t.startsWith("0") && t.length() > 1) return;
            res.add(s);
        }
        if((dots+1)*3 < s.substring(index).length()) return;

        for(int i = 1; i <= 3; i++) {
            if(s.substring(index).length()<i) continue;;
            String tmp = s.substring(index,index+i);
            if(Integer.parseInt(tmp) > 255) continue;
            if(tmp.startsWith("0") && tmp.length() > 1) continue;
            String newS = s.substring(0,index+i)+'.'+s.substring(index+i);
            getIPs(newS,index+i+1, dots-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddress().restoreIpAddresses("0000"));
    }
}
