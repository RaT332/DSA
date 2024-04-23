package com.gfg.questions.Array;

import java.util.ArrayList;

public class SubArraySum {
    static ArrayList<Integer> subarraySumMySolution(int[] arr, int n, int s)
    {
        int sumInWindow=0;// 1
        int starting=0,ending=0;// 0 , 1

        while(ending!=arr.length){

            if(sumInWindow<s)
                sumInWindow+=arr[ending++];

            if(sumInWindow>s)
                sumInWindow-=arr[starting++];

            if(sumInWindow==s){
                ending--;
                break;   }
        }
        ArrayList<Integer> listOfIndex = new ArrayList<Integer>();

        if(sumInWindow!=s){
            listOfIndex.add(-1);
            return listOfIndex;
        }

        listOfIndex.add(starting+1);
        listOfIndex.add(ending+1);
        return listOfIndex;
    }


    static ArrayList<Integer> subarraySumOptimal(int[] arr, int n, int s)
    {
        ArrayList<Integer> listOfIndex = new ArrayList<Integer>();
        int currentSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > s && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == s) {
                int p = i - 1;
                listOfIndex.add(start+1);
                listOfIndex.add(p+1);
                return listOfIndex;
            }

            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }

        listOfIndex.add(-1);
        return listOfIndex;
    }
}
