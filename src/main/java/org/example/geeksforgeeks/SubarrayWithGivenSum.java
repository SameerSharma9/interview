package org.example.geeksforgeeks;

// https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&sortBy=submissions

import java.util.*;

public class SubarrayWithGivenSum {
    //{1,2,3,7,5} 12 2-4
    //1,2,3,4,5,6,7,8,9,10 15
    //(1-based indexing)
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int start = 0;
        int last = 0;
        boolean flag=false;
        int currsum=0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        //iterating over the array.
        for(int i=0;i<n;i++)
        {
            //storing sum upto current element.
            currsum+= arr[i];

            //checking if current sum is greater than or equal to given number.
            if(currsum>=s)
            {
                last=i;
                //we start from starting index till current index and do the
                //excluding part while s(given number) < currsum.
                while(s<currsum && start<last)
                {
                    //subtracting the element from left i.e., arr[start]
                    currsum-= arr[start];
                    ++start;
                }

                //now if current sum becomes equal to given number, we store
                //the starting and ending index for the subarray.
                if(currsum==s)
                {
                    res.add(start + 1);
                    res.add(last + 1);

                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag==false) {
            res.add(-1);
        }
        //returning the result.
        return res;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayWithGivenSum.subarraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 13));
    }
}
