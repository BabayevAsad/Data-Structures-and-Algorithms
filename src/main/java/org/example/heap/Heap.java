package org.example.heap;

import java.util.PriorityQueue;

public class Heap {

    /// example inputs:{6, 5, 4, 3, 2, 1} k=2; {5, 2, 8, 8, 1, 5, 4} k=3
    public static int findLargestElement(int arr[], int k){
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        while(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}