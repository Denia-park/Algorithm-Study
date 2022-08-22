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

        //Queue1 을 생성하고 값을 입력 후 sum1 을 계산
        Queue<Integer> newQueue1 = new LinkedList<>();
        for (int i : queue1) {
            sum1 += i;
            newQueue1.add(i);
        }

        //Queue2 을 생성하고 값을 입력 후 sum2 을 계산
        Queue<Integer> newQueue2 = new LinkedList<>();
        for (int i : queue2) {
            sum2 += i;
            newQueue2.add(i);
        }

        //TotalSum 계산
        totalSum = sum1 + sum2;

        //totalSum 이 홀수라면 바로 return -1
        if (totalSum % 2 != 0) return -1;

        //전체 값의 절반을 구한다.
        halfTotalSum = (totalSum / 2);

        //sum1 , sum2 다르면 while 루프 실행
        while (sum1 != sum2) {
            //버퍼를 아무리 움직여도 queue1.length * 3 이상 움직인 경우는 더 이상 옮겨도 답을 구할 수 없으므로 -1을 return 한다.
            if(answer > queue1.length * 3) return -1;

            //Sum1 이 크면 Queue1 의 poll 하고 Queue2 에 Add
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
            //Sum2 이 크면 Queue2 의 poll 하고 Queue1 에 Add
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
        //poll 한 값이 halfTotalSum 보다 크면 아무리 계산해도 큐의 합을 맞출 수 없으므로 -1을 return 하고
        //해당 메서드 외부에서 해당 메서드의 return 값이 -1 이 나오면 solution 메서드의 값을 -1로 return 하게 만듬
        if(sourceFirstValue > halfTotalSum) return -1;
        destQueue.add(sourceFirstValue);
        return sourceFirstValue;
    }
}
