package org.example.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//https://leetcode.com/problems/peeking-iterator/
class PeekingIterator<T> implements Iterator {
    List<T> list;
    private Integer cur;
    public PeekingIterator(Iterator<T> iterator) {
        // initialize any member here.
        list = new ArrayList<T>();
        cur = 0;
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        if(list.isEmpty() || list.size() == cur) return null;
        return list.get(cur);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        if(list.isEmpty() || list.size() == cur) return null;
        return list.get(cur++);

    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty() || list.size() == cur) return false;
        else return true;
    }
}