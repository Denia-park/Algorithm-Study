package com.company;

import java.util.Queue;

class Solution {
    long halfTotalSum;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        long totalSum = 0;
        long arrSum = 0;
        halfTotalSum = 0;

        int[] totalArray = new int[(queue1.length + queue2.length)*2];

        int index = 0;
        for (int i : queue1) {
            sum1 += i;
            totalArray[index++] = i;
        }
        for (int i : queue2) {
            sum2 += i;
            totalArray[index++] = i;
        }
        for (int i : queue1) {
            totalArray[index++] = i;
        }
        for (int i : queue2) {
            totalArray[index++] = i;
        }

        totalSum = sum1 + sum2;

        //totalSum 이 홀수라면 바로 return -1
        if (totalSum % 2 != 0) return -1;

        halfTotalSum = (totalSum / 2);

        int arrLength = totalArray.length;
        int queueLength = queue1.length;

        for (int i = 0; i < arrLength/2 - 1; i++) {
            arrSum = 0;
            for (int j = i; j < i + queueLength; j++) {
                arrSum += totalArray[j];
            }
            if(arrSum == halfTotalSum){
                return answer;
            }else if(arrSum > halfTotalSum){
                queueLength -= 1;
            }else{
                queueLength += 1;
                i -= 1;
            }
            answer++;
        }

        return -1;
    }
}
