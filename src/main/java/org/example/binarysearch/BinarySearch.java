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

    /// example inputs:{1,2,3,4,5,6,7,9,10} target=8; {3, 5, 7, 9} target:1
    public static int searchInsertPosition(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;
        int left=0;
        int right=arr.length-1;


        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(target>arr[mid]){
                left=mid+1;
            }
            else if(target<arr[mid]){
                right=mid-1;
            }
        }
        return left;
    }

    /// example inputs: {1, 2, 1, 3, 5, 6, 4}, {1, 2, 3, 1}
    /// Return its index
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
