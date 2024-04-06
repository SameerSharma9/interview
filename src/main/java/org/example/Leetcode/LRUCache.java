package org.example.Leetcode;

import javafx.util.Pair;

import java.util.*;

//https://leetcode.com/problems/lru-cache/
class LRUCache {
    Map<Integer, Pair> map;
    private int capacity;
    private int filled;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);

    }

    public int get(int key) {
        System.out.println(map);
        if(map.get(key) != null) {
            Pair p = map.remove(key);
            map.put(key,p);
            return  (Integer)p.getValue();
        } else return -1;
    }

    public void put(int key, int value) {
        if(map.get(key) != null) {
            Pair p = map.remove(key);
        } else {
            if(filled > capacity) {
                Integer firstKey =  map.entrySet()
                        .stream()
                        .map(x->x.getKey())
                        .findFirst().get();
                map.remove(firstKey);

            }
            map.put(key, new Pair(key, value));

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */