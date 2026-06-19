package org.example.twoPointer;

import java.util.Arrays;

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

    /// Example inputs: "A man, a plan, a canal: Panama", "No 'x' in Nixon", "Was it a car or a cat I saw?"
    /// We ignore spaces, punctuations and cases
    public static boolean checkPalindrome(String text){
        if(text==null) return false;
        if(text.length()==1) return true;

        text=text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int left=0;
        int right=text.length()-1;

        while(left<right){
            if(text.charAt(left)!=text.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /// Example inputs:Hello World, Champions league, Git commit
    public static String reverseString(String text){
        if(text==null || text.length()==1) return text;

        char arr[] = text.toCharArray();
        int left=0;
        int right=text.length()-1;

        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

            right--;
            left++;
        }

        return new String(arr);
    }

    /// new int[]{1,1,1,2,2,3,4,5,6}, {0,0,1,1,1,2,3,4,4,4,5}
    /// removing continuous duplicates, and replace remaining elements with 0
    public static String removeDuplicates(int[] arr){
        if(arr==null || arr.length==0) return "[]";

        int left=0;
        for(int right=1; right<arr.length; right++){
            if(arr[right]!=arr[left]){
                left++;
                arr[left]=arr[right];
            }
        }

        for (int i = left + 1; i < arr.length; i++) {
            arr[i] = 0;
        }

        return Arrays.toString(arr);
    }
}