package org.example.recursion;

// https://leetcode.com/problems/combinations/description/

import java.util.*;
import java.util.stream.Collectors;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        compute(1, n, k, new LinkedList<>(), res);
        return res;
    }

    private void compute(int start, int n, int k, LinkedList<Integer> lis, List<List<Integer>> res) {
        if(lis.size() == k) {
            //TreeSet<Integer> ls = lis.stream().collect(Collectors.toCollection(TreeSet::new));
            res.add(new ArrayList<>(lis));
            return;
        }
        for(int i = start; i <= n; i++) {
            //if(!lis.contains(i)) {
                lis.add(i);
                compute(i+1, n,k,lis,res);
                lis.remove(lis.size()-1);
           // }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Combinations().combine(4,2);
        System.out.println(res);
    }
}
