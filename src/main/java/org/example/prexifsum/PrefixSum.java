package org.example.prexifsum;

import java.util.HashMap;

public class PrefixSum {

    /// example inputs:{1, 2, 3, 4, 5}   L=2, R=4;{1000, 2000, 3000, 4000}, L = 1, R = 3
    /// Sum of elements from index L to R
    public static int sumOfElementsRange(int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) return -1;
        if (L < 0 || R >= arr.length || L > R) return -1;

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return prefix[R + 1] - prefix[L];
    }

    /// example inputs: {1,7,3,6,5,6}, {2, 1, -1}
    /// Find Pivot Index using Prefix Sum
    public static int findPivotIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int leftSum = prefix[i];
            int rightSum = prefix[arr.length] - prefix[i + 1];

            if (leftSum == rightSum) return i;
        }

        return -1;
    }

    /// example input arr:{1, 1, 2,2,0,0,0}, k=2; arr:{1, 1, 2,2,0,0,0,2}, k=2;
    /// Subarray Sum Equals K
    public static int subarraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int resultCount = 0;
        int currentSum = 0;

        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (map.containsKey(currentSum - k)) {
                resultCount += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return resultCount;
    }
}
