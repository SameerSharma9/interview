package org.example.recursion;

// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList<>());
        compute(0, nums, new LinkedList<>(), res);
        return res;
    }

    private void compute(int start, int[] nums, LinkedList<Integer> lis, List<List<Integer>> res) {
        res.add(new ArrayList<>(lis));
        for(int i = start; i < nums.length; i++) {
            lis.add(nums[i]);
            compute(i+1, nums,lis,res);
            lis.remove(lis.size()-1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, arr, res);
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> arr, List<List<Integer>> res) {
        res.add(new ArrayList<>(arr));
        for(int i = idx; i < nums.length; i++) {
            arr.add(nums[i]);
            backtrack(nums,i+1, arr, res);
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Subset().subsets2(new int[]{1,2,2});
        System.out.println(res);
    }
}
