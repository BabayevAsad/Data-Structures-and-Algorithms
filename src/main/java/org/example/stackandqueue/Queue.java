package org.example.stackandqueue;

import java.util.ArrayDeque;

public class Queue {

    /// example inputs tickets: {2, 3, 2}, customerIndex:2; tickets = {1, 1, 5, 1, 1}, customerIndex = 2
    /// Time Needed to Buy Tickets
    public static int buyingTicket(int [] tickets, int customerIndex){
        if (customerIndex < 0 || customerIndex >= tickets.length) return -1;

        java.util.Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < tickets.length; i++){
            queue.offer(new int[]{tickets[i], i});
        }

        int time=0;

        while(!queue.isEmpty()){
            int[] customer =  queue.poll();

            customer[0]--;
            time++;

            if(customer[1]==customerIndex && customer[0]==0){
                return time;
            }

            if(customer[0]>0){
                queue.offer(customer);
            }
        }
        return time;
    }
}
