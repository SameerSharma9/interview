package org.example.hackerrank.recursion;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}

class Solution {
    public void combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List> result = new HashSet<>();
        backtrack(candidates,0, target, new ArrayList<>(), result);
        System.out.println(result);
    }

    private void backtrack(int[] candidates, Integer start, Integer target, List<Integer> list, Set<List> result) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(list);
        }
        for(int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i+1, target - candidates[i], list, result);
            list.remove(list.size() -1);
        }
        }
}
