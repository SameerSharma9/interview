package org.example.Leetcode.arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class RemoveDuplicate {
    // 1 1 1 1 1 2 2 3 4 4 4 5 6
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return 1;
        int res = 1;
        for(int i = 1, j = 1; i < nums.length; i++, j++) {
            if(nums[i-1] == nums[i]) {

                while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
            }
            if(i != j) {
                nums[j] = nums[i];
            }
            res++;
        }
        //System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new RemoveDuplicate().removeDuplicates(new int[]{1,1,1,2,2,3} ));
    }
}
