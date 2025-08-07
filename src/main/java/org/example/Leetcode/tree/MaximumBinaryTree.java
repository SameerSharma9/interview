package org.example.Leetcode.tree;

// https://leetcode.com/problems/maximum-binary-tree/description/?envType=problem-list-v2&envId=stack

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findMaxNode(nums, 0, nums.length-1);
    }

    private int findMaxIndex(int[] nums, int left, int right) {
        if(right < left) return -1;
        if(left == right) return left;

        int index = left;
        int max = nums[left];
        for(int i = left; i<= right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    private TreeNode findMaxNode(int[] nums, int left, int right) {
        int index = findMaxIndex(nums, left, right);
        if(index < 0) return null;
        return new TreeNode(nums[index], findMaxNode(nums, left, index-1), findMaxNode(nums, index+1, right));
    }

    public static void main(String[] args) {
        MaximumBinaryTree tree = new MaximumBinaryTree();
        TreeNode root = tree.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
       // System.out.println(root.val);
    }
}
