package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        //삽입 : offer , add
        //제거 : poll , remove
        queue.add(1);
        queue.offer(2);
        queue.poll();
        queue.offer(3);
        queue.offer(4);
        queue.remove();

        System.out.println(queue);
    }
}
