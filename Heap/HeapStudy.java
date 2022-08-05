package com.company.Heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapStudy {

    public static void main(String[] args) {
        testMaxHeap();
        testMinHeap();
    }


    private static void testMinHeap() {
        PriorityQueue<Integer> minHeap_PriorityQueue = new PriorityQueue<Integer>();
        minHeap_PriorityQueue.add(1);
        minHeap_PriorityQueue.add(2);
        minHeap_PriorityQueue.add(3);
        minHeap_PriorityQueue.add(4);

        System.out.println("The highest value in the heap:" + minHeap_PriorityQueue.peek());

        minHeap_PriorityQueue.poll(); //루트 노드에서 값을 반환하고 제거
        minHeap_PriorityQueue.remove(3);

        System.out.println("after removing 3:");

        Iterator<Integer> itr = minHeap_PriorityQueue.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        boolean has3 = minHeap_PriorityQueue.contains(3);
        System.out.println("Does the heap contatins 3 ? " + has3);
    }

    private static void testMaxHeap() {
        PriorityQueue<Integer> maxHeap_PriorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap_PriorityQueue.add(1);
        maxHeap_PriorityQueue.add(3);
        maxHeap_PriorityQueue.add(2);
        maxHeap_PriorityQueue.add(4);

        System.out.println("The highest value in the heap:" + maxHeap_PriorityQueue.peek());

        maxHeap_PriorityQueue.poll(); //루트 노드에서 값을 반환하고 제거
        maxHeap_PriorityQueue.remove(3);

        System.out.println("after removing 3:");

        Iterator<Integer> itr = maxHeap_PriorityQueue.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        boolean has2 = maxHeap_PriorityQueue.contains(2);
        System.out.println("Does the heap contatins 2 ? " + has2);
    }

}
