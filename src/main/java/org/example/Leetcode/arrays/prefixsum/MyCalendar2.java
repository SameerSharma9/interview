package org.example.Leetcode.arrays.prefixsum;

// https://leetcode.com/problems/my-calendar-ii/?envType=problem-list-v2&envId=prefix-sum

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar2 {

    TreeMap<Integer, Integer> map;
    int maxBooking;

    public MyCalendar2() {
        map = new TreeMap<>();
        maxBooking = 2;
    }

    public boolean book(int startTime, int endTime) {
        int count = 0;
        if(map.containsKey(startTime)) {
            map.put(startTime, map.get(startTime) + 1);
        } else {
            map.put(startTime, 1);
        }
        if(map.containsKey(endTime)) {
            map.put(endTime, map.get(endTime) - 1);
        } else {
            map.put(endTime, -1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > maxBooking) {
                map.put(startTime, map.get(startTime)-1);
                map.put(endTime, map.get(endTime)+1);
                return false;
            }
        }
        return true;
    }

    //["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
    //[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]

    //[[],[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]

    public static void main(String[] args) {
        MyCalendar2 obj = new MyCalendar2();
        System.out.println(obj.book(24,40));
        System.out.println(obj.book(43,50));
        System.out.println(obj.book(27,43));
        System.out.println(obj.book(5,21));
        System.out.println(obj.book(30,40));
        System.out.println(obj.book(14,29));
        System.out.println(obj.book(3,19));
        System.out.println(obj.book(3,14));
        System.out.println(obj.book(25,39));
        System.out.println(obj.book(6,19));
    }
}
