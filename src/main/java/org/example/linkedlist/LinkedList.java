package org.example.linkedlist;


public class LinkedList {

    /// example inputs: ListNode1 2->4->3  ListNode2 5->6->4
    ///Given two linked lists representing non-negative integers in reverse order, return their sum as a linked list.
    /// Code for main class-->
    /// LinkedList solver = new LinkedList();
    ///
    ///         ListNode l1 = new ListNode(2);
    ///         l1.next = new ListNode(4);
    ///         l1.next.next = new ListNode(3);
    ///
    ///         ListNode l2 = new ListNode(5);
    ///         l2.next = new ListNode(6);
    ///         l2.next.next = new ListNode(4);
    ///
    ///         ListNode result = solver.addTwoNumbers(l1, l2);
    ///
    ///         System.out.println(result);

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode resultHead = new ListNode(0);
        ListNode current = resultHead;

        int carry=0;

        while(l1 != null || l2 != null || carry !=0){
            int sum = carry;

            if(l1 != null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2 != null){
                sum+=l2.val;
                l2=l2.next;
            }

            carry =sum/10;

            current.next = new ListNode(sum%10);
            current = current.next;
        }

        return resultHead.next;
    }
}
