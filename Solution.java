package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    long halfTotalSum;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long totalSum = 0;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> newQueue1 = new LinkedList<>();
        for (int i : queue1) {
            sum1 += i;
            newQueue1.add(i);
        }
        Queue<Integer> newQueue2 = new LinkedList<>();
        for (int i : queue2) {
            sum2 += i;
            newQueue2.add(i);
        }

        totalSum = sum1 + sum2;

        //totalSum 이 홀수라면 바로 return -1
        if (totalSum % 2 != 0) return -1;

        halfTotalSum = (totalSum / 2);
        while (!((sum1 == halfTotalSum) && (sum2 == halfTotalSum))) {
            if (sum1 > halfTotalSum) {
                if(moveValueToAnotherQueue(newQueue1, newQueue2))
                    answer ++;
                else
                    return -1;
            }
            else if (sum2 > halfTotalSum) {
                if(moveValueToAnotherQueue(newQueue2, newQueue1))
                    answer ++;
                else
                    return -1;
            }

            sum1 = getSum(newQueue1);
            sum2 = getSum(newQueue2);
        }

        return answer;
    }

    private boolean moveValueToAnotherQueue(Queue<Integer> sourceQueue, Queue<Integer> destQueue) {
        boolean rtVal = true;
        int sourceFirstValue = sourceQueue.poll();
        if(sourceFirstValue > halfTotalSum) return false;
        destQueue.add(sourceFirstValue);
        return rtVal;
    }

    private long getSum(Queue<Integer> queue) {
        long rtVal = 0;
        for (int i : queue) {
            rtVal += i;
        }
        return rtVal;
    }
}
