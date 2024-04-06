package org.example.Leetcode.arrays;

// https://leetcode.com/problems/permutations/description/

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    //1,2,3
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        compute(nums, new LinkedList<>(), res);
        //System.out.println(res);
        return res;
    }

    private void compute(int[] nums, List<Integer> set, List<List<Integer>> res) {
        if(set.size() == nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        for(int j = 0; j < nums.length; j++) {
            if(set.contains(nums[j])) continue;
            set.add(nums[j]);
            compute(nums, set,res);
            set.remove(set.size()-1);
         }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[]{1,2,3}));
    }
}
