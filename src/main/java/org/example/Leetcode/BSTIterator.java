package org.example.Leetcode;

import javax.swing.tree.TreeNode;
import java.util.Stack;


 //Definition for a binary tree node.
 class TreeNodee {
     int val;
     TreeNodee left;
     TreeNodee right;
     TreeNodee() {}
     TreeNodee(int val) { this.val = val; }
     TreeNodee(int val, TreeNodee left, TreeNodee right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class BSTIterator {


    Stack<TreeNodee> stack;

    public BSTIterator(TreeNodee root) {
        stack = new Stack<>();
        stack.push(root);
        TreeNodee cur = root;
        while(cur.left != null) {
            cur = cur.left;
            stack.push(cur);
        }
    }

    public int next() {

        TreeNodee cur = stack.pop();
        int temp = cur.val;
        if(cur.right != null) {
            cur = cur.right;
            stack.push(cur);
                 while(cur.left != null) {
                        cur = cur.left;
                 }      stack.push(cur);
        }


        return temp;

    }

    public boolean hasNext() {

        if(stack.isEmpty())   return false;
        else return true;

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */