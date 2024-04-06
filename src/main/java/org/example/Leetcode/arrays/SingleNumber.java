package org.example.Leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber {
//    public int singleNumber(int[] nums) {
//        Map.Entry<Integer, Long> val = Arrays.stream(nums)
//                .mapToObj(Integer::valueOf)
//                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
//                .entrySet().stream()
//                .filter(a -> a.getValue() == 1).findFirst().get();
//        return val.getKey();
//    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
