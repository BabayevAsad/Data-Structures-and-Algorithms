package org.example.slidingWindow;

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
}
