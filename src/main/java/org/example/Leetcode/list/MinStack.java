package org.example.Leetcode.list;

// https://leetcode.com/problems/min-stack/?envType=problem-list-v2&envId=stack

import java.util.LinkedList;

public class MinStack {

    LinkedList<MinStackNode> list = new LinkedList<>();

    public MinStack() {
    }

    public void push(int val) {
        MinStackNode node = new MinStackNode(val, null);
        if(list.isEmpty()) {
            node.minNode = node;
            list.add(node);
            return;
        }

        if(val < list.getLast().minNode.val) {
            node.minNode = node;
        } else {
            node.minNode = list.getLast().minNode;
        }
        list.add(node);

    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast().val;
    }

    public int getMin() {
        return list.getLast().minNode.val;
    }

    public static void main(String[] args) {

          MinStack obj = new MinStack();
          obj.push(-2);
          obj.push(0);
          obj.push(-3);
        System.out.println(obj.getMin());
          obj.pop();
        System.out.println(obj.top());
        System.out.println( obj.getMin());
    }
}

class MinStackNode {
    int val;
    MinStackNode minNode;

    public MinStackNode(int val, MinStackNode minNode) {
        this.val = val;
        this.minNode = minNode;
    }
}
