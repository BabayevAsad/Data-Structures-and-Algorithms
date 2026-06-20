package org.example.prexifsum;

public class PrefixSum {

    /// example inputs:{1, 2, 3, 4, 5}   L=2, R=4;{1000, 2000, 3000, 4000}, L = 1, R = 3
    /// Sum of elements from index L to R
    public static int sumOfElementsRange(int[] arr, int L, int R){
        if (arr == null || arr.length == 0) return -1;
        if (L < 0 || R >= arr.length || L > R) return -1;

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return prefix[R+1]-prefix[L];
    }
}
