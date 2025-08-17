package org.example.Leetcode.tree;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/?envType=problem-list-v2&envId=depth-first-search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NextRightPointer {

    public Node connect2(Node root) {
        if(root == null || root.left == null) return root;
        List<Node> ls = new LinkedList<>();
        ls.add(root);
        traverse(ls);
        return root;
    }

    private void traverse(List<Node> ls) {
        if(ls.isEmpty()) return;
        if(ls.get(0) == null || ls.get(0).left == null) {
            ls.remove(0);
            return ;
        }
        ls.get(0).left.next = ls.get(0).right;
        if(ls.get(0).next != null) {
            ls.get(0).right.next = ls.get(0).next.left;
        }
        ls.add(ls.get(0).left);
        ls.add(ls.get(0).right);

        ls.remove(0);
        traverse(ls);
    }

    public Node connect(Node root) {
        if(root == null) return root;
        List<Node> ls = new LinkedList<>();
        ls.add(root);
        bfs(0, ls);
        int nodes = ls.size();
        int levels = (int) Math.ceil(Math.log(nodes + 1) / Math.log(2)); // Calculate levels
        int number = 1; // Start numbering from 1
        for (int i = 0; i < levels; i++) {
            int levelNodes = (int) Math.pow(2, i); // Number of nodes at the current level
            for (int j = 0; j < levelNodes; j++) {
                if(j != levelNodes-1) {
                    ls.get(0).next = ls.get(1);
                }
                ls.remove(0);
            }
        }
        return root;
    }
    private void bfs(int index, List<Node> ls) {
        while(index != ls.size()) {
            Node left = ls.get(index).left;
            Node right = ls.get(index).right;
            if(left != null) ls.add(ls.get(index).left);
            if(right != null) ls.add(ls.get(index).right);
            index++;
        }
    }

    public static void main(String[] args) {
        int nodes = 3;
        int levels = (int) Math.ceil(Math.log(nodes + 1) / Math.log(2)); // Calculate levels

        int number = 1; // Start numbering from 1
        for (int i = 0; i < levels; i++) {
            int levelNodes = (int) Math.pow(2, i); // Number of nodes at the current level
            for (int j = 0; j < levelNodes && number <= nodes; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println(); // Move to the next line after each level
        }
    }
}



// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
