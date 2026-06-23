package org.example;

import org.example.heap.Heap;
import org.example.linkedlist.LinkedList;
import org.example.linkedlist.ListNode;


public class Main {
    public static void main(String[] args) {

        LinkedList solver = new LinkedList();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solver.addTwoNumbers(l1, l2);

        System.out.println(result);

    }
}