package org.example.hackerrank.array;

// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?page=1&sortBy=submissions

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        int max = arr[arr.length-1];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(max);
        if(arr.length == 1) return res;
        for(int i = arr.length-2; i >= 0; i--) {
            if(arr[i] > max) {
                max = arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
