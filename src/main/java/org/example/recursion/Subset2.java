package org.example.recursion;

//https://leetcode.com/problems/subsets-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSet(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void findSet(int[] nums, int idx, List<Integer> ls, List<List<Integer>> res) {
        if(!res.contains(ls)) {
            res.add(new ArrayList<>(ls));
        }
        for(int i = idx; i < nums.length; i++) {

            ls.add(nums[i]);
            findSet(nums, i+1, ls, res);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Subset2().subsetsWithDup(new int[]{1,2,2});
        System.out.println(res);
    }

}
