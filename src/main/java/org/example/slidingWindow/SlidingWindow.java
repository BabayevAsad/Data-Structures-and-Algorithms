package org.example.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /// Example inputs:{2,1,5,1,3,2} k=3; {1,12,-5,-6,50,3} k=3
    /// Maximum Sum Subarray of Size K
    public static int maxSumSubArray(int[] arr, int k){
        if (arr==null || arr.length<k) return 0;

        int windowSum=0;

        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }

        int maxSum=windowSum;

        for(int i=k;i<arr.length;i++){
            windowSum+=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }

        return maxSum;
    }

    /// example inputs:"bacaefgh", "pvavkepv";
    /// Longest Substring Without Repeating Characters
    public static int longestSubstringWithoutRepeating(String text){
        if (text==null || text.length()==0) return 0;
        if (text.length()==1) return 1;

        Map<Character,Integer> map= new HashMap<>();
        int left=0;
        int max=0;

        for(int i=0;i<text.length();i++){
            char currentChar = text.charAt(i);

            if(map.containsKey(currentChar)){
                left=Math.max(left,map.get(currentChar)+1);
            }

            map.put(currentChar,i);
            max=Math.max(max,i-left+1);
        }

        return max;
    }
}
