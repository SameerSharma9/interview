package org.example.Leetcode.arrays;

// https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumTwiceOther {
    public int dominantIndex(int[] nums) {

        List<Integer> sortedList = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(sortedList.get(0)/2 >= sortedList.get(1)) {
            int j = 0;
            for(int i: nums) {
                if(i == sortedList.get(0)) return j;
                j++;
            }
        }
        return -1;
    }
}
