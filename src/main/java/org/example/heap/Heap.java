package org.example.heap;

import java.util.HashMap;
import java.util.Map;
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

    /// example inputs:{1, 1, 1, 2, 2, 3} k=2; {4, 4, 4, 5, 5, 5, 6, 6, 6} k=2
    public static int[] topKFrequent(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) return new int[0];

        Map<Integer,Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() < k) return new int[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int i : map.keySet()){
            heap.offer(i);
        }

        while(heap.size()>k){
            heap.poll();
        }

        int result[] = new int[k];

        for(int i=0; i<k; i++){
            result[i]=heap.poll();
        }

        return result;
    }
}