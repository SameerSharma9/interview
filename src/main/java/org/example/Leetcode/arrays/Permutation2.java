package org.example.Leetcode.arrays;

// https://leetcode.com/problems/permutations-ii/description/

import java.util.*;

public class Permutation2 {
    //1,1,2
    public List<List<Integer>> permute(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        //Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        compute(nums, new HashSet<>(), new LinkedList<>(), res);
        //System.out.println(res);
        return new ArrayList<>(res);
    }

    private void compute(int[] nums, Set<Integer> index, List<Integer> set, Set<List<Integer>> res) {
        if(set.size() == nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        for(int j = 0; j < nums.length; j++) {
            if(index.contains(j)) continue;
            set.add(nums[j]);
            index.add(j);
            compute(nums, index, set,res);
            index.remove(j);
            set.remove(set.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation2().permute(new int[]{1,1,3}));
    }
}