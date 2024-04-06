package org.example.geeksforgeeks;

public class MinNumberJumps {

    static int minJumps(int arr[])
    {

        // The number of jumps needed to reach the starting index is 0
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];  // stores all time the maximal reachable index in the array.
        int step = arr[0];      // stores the number of steps we can still take
        int jump =1;//stores the number of jumps necessary to reach that maximal reachable position.

        // Start traversing array
        int i=1;
        for (; i < arr.length; i++)
        {
            // Check if we have reached the end of the array
            if (i == arr.length-1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i+arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0)
            {
                // we must have used a jump
                jump++;

                // Check if the current index/position or lesser index
                // is the maximum reach point from the previous indexes
                if(i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }
    int minJump(int[] arr) {
        int jump = 0;
        for(int i = 0; i < arr.length; ) {
            if(i+arr[i] >= arr.length-1) return ++jump;
            int tempMax = 0;
            int index = 0;
            for(int j = 0; j < arr[i]; j++) {
                int t = arr[i+1+j] - (arr[i]-(j+1));
                if(t > tempMax) {
                    tempMax = t;
                    index = i+1+j;
                }
            }
            i = index;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        int res = MinNumberJumps.minJumps(new int[]{5,9,3,2,1,0,2,3,3,1,0,0});
        System.out.println(res);
    }
}
