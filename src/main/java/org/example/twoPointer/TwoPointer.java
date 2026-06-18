package org.example.twoPointer;

public class TwoPointer {

    /// example inputs: arr[2,7,11,15] (for sorted arrays), target 9;
    public static void findTwoSum(int arr[], int target){
        if (arr == null || arr.length < 2) {
            System.out.println("No pair found (Invalid input)");
            return;
        }

        int left=0;
        int right=arr.length-1;

        while(left<right){
            int sum=arr[left]+arr[right];

            if(sum==target){
                System.out.println(String.format("Indexs:[%d,%d]\nNumbers:[%d,%d]", left, right,arr[left],arr[right]));
                return;
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
    }
}
