package org.example.Leetcode;

// https://leetcode.com/problems/jump-game/

public class JumpGame2 {
    public boolean canJump(int[] nums) {
        if(nums.length > 1 && nums[0] == 0) return false;
        int step = nums[0];
        int maxS = step;
        for(int i = 1; i < nums.length-1; i++) {
            maxS = Math.max(maxS, nums[i]+i);
            step--;
            if(step == 0) {
                if(i >= maxS) return false;
                step = maxS - i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}
