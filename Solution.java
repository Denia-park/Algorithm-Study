package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    long halfTotalSum;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        long totalSum = 0;
        halfTotalSum = 0;

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
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int movingValue = moveValueToAnotherQueue(newQueue1, newQueue2);
                if(movingValue != -1){
                    sum1 -= movingValue;
                    sum2 += movingValue;
                    answer ++;
                }
                else
                    return -1;
            }
            else{
                int movingValue = moveValueToAnotherQueue(newQueue2, newQueue1);
                if(movingValue != -1){
                    sum2 -= movingValue;
                    sum1 += movingValue;
                    answer ++;
                }
                else
                    return -1;
            }
        }

        return answer;
    }

    private int moveValueToAnotherQueue(Queue<Integer> sourceQueue, Queue<Integer> destQueue) {
        int sourceFirstValue = sourceQueue.poll();
        if(sourceFirstValue > halfTotalSum) return -1;
        destQueue.add(sourceFirstValue);
        return sourceFirstValue;
    }
}
