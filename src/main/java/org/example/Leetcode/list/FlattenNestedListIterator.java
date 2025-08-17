package org.example.Leetcode.list;

// https://leetcode.com/problems/flatten-nested-list-iterator/?envType=problem-list-v2&envId=stack

import java.util.*;

public class FlattenNestedListIterator {
}


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
  // Input: nestedList = [1,[4,[6]]]
 // Input: nestedList = [[1,1],2,[1,1]]
class NestedIterator implements Iterator<Integer> {

    List<Integer> queue = null;

    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<>();
        queue.addAll(unwrap(nestedList));
    }

    private List<Integer> unwrap(List<NestedInteger> nestedList) {
        List<Integer> ls = new LinkedList<>();
        for(NestedInteger i : nestedList) {
            if(i.isInteger()) {
                ls.add(i.getInteger());
            } else {
                ls.addAll(unwrap(i.getList()));
            }
        }
        return ls;
    }

    @Override
    public Integer next() {
        if (index < queue.size()) {
            return queue.get(index++);
        }
        throw new InternalError("out of bound!");
    }

    @Override
    public boolean hasNext() {
        if(index < queue.size()) return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */