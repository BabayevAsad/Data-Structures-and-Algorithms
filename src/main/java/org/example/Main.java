package org.example;

import org.example.heap.Heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Heap.topKFrequent(new int[]{4, 4, 4, 5, 5, 5, 6, 6, 6},4)));
    }
}