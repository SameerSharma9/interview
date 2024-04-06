package org.example.Leetcode;

import java.util.*;

//https://leetcode.com/problems/min-stack/
/*
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
import java.util.Stack;
import java.util.TreeSet;
class MinStack {

    Stack<Integer> stack;
    List<Integer> set;

    public MinStack() {
        stack = new Stack<>();
        set = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        set.add(val);
        Collections.sort(set,Comparator.naturalOrder());
    }

    public void pop() {
        Integer i = stack.pop();
        set.remove(i);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return set.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
