package org.example.binarysearch;

public class BinarySearch {

    /// example inputs:{1,2,3,4,5,6,7,8,9,10} target=2; {2,4,6,8,10} target=10
    public static int binarySearch(int[] arr, int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
