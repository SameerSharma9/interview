package org.example.recursion;

// https://leetcode.com/problems/permutation-sequence/

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if(n == 1) return String.valueOf(n);
        int t = 1;
        for(int i = 1; i <= n-1; i++) {
            t *= i;
        }
        double dw = (double)k-0.1d;
        int d = (int)(dw/t);
        int r = k%t;
        List<String> res = new LinkedList<>();
        String ns = IntStream.rangeClosed(1,n)
                .mapToObj(i -> String.valueOf(i))
                .collect(Collectors.joining(""));
        List<Character> c = new LinkedList<>();


        c.add(ns.charAt(d));

        getPermutationSequence(ns, c, r, res);
        return res.get(res.size()-1);
    }

    private void getPermutationSequence(String s, List<Character> ls, Integer k, List<String> res) {
        if(s.length() == ls.size()) {
            res.add(ls.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
        for(int i = 0; i < s.length(); i++) {
            if(ls.contains(s.charAt(i))) continue;
            ls.add(s.charAt(i));
            getPermutationSequence(s,ls, k,res);
            if(k == res.size()) return ;
            ls.remove(ls.size()-1);
        }
    }

    private String getPermutation2(int n, int k) {
        StringBuilder ans = new StringBuilder();
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i < n; ++i) {
            int fact = 1;
            for (int j = 1; j < n - i; ++j) {
                fact *= j;
            }
            for (int j = 1; j <= n; ++j) {
                if (!vis[j]) {
                    if (k > fact) {
                        k -= fact;
                    } else {
                        ans.append(j);
                        vis[j] = true;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation2(4,  9));
    }
}
