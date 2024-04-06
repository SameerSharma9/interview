package org.example.recursion;

// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        compute(0, nums, new LinkedList<>(), res);
        return res;
    }

    private void compute(int start, int[] nums, LinkedList<Integer> lis, List<List<Integer>> res) {
        if(start >= nums.length || lis.contains(nums[start])) return;


        for(int i = start; i < nums.length; i++) {
            //System.out.println(start+" "+i);
            lis.add(nums[i]);
            if(!res.contains(lis)){
                res.add(new ArrayList<>(lis));
                //return;
            }
            compute(i+1, nums,lis,res);
            lis.remove(lis.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Subset().subsets(new int[]{1,2,3});
        System.out.println(res);
    }
}
