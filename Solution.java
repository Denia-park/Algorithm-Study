package com.company;

import java.util.*;

public class Solution {
    static public void main(String[] args) {
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};


        System.out.println(Arrays.toString(solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
    }

    static public Integer[] solution(int[] progresses, int[] speeds) {
        Integer[] answer = {};
        int answerCount = 0;
        List<Integer> answerList = new ArrayList<Integer>();

        Queue<Integer> answerQueue = new LinkedList<>();

        while (answerCount != progresses.length) {
            int tempCount = 0;

            int index = 0;

            for (int i = 0; i < progresses.length; i++) {
                if(progresses[i] != -1 && progresses[i] != -2)
                    progresses[i] = progresses[i] + speeds[index];

                if(progresses[i] >= 100)
                    progresses[i] = -1;
            }

            for (int i = 0; i < progresses.length; i++) {
                if(progresses[i] == -1){
                    tempCount++;
                    progresses[i] = -2;
                }
            }

            if(tempCount != 0){
                answerList.add(tempCount);
                answerCount = answerCount + tempCount;
            }
        }

        return answerList.toArray(answer);
    }
}
