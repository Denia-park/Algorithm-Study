package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args){
        int[] numbers = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};

        int[] rtValArr = {5, 6, 3};

        System.out.println(Arrays.equals(solution(numbers, commands), rtValArr));
    }

    static public int[] solution(int[] numbers, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;

        //전체 명령을 iter
        for (int[] command : commands) {
            int arrCutStart = command[0];
            int arrCutFinal = command[1];
            int answerIndex = command[2];

            int[] notSortingArr = new int[arrCutFinal - arrCutStart + 1];
            for (int i = (arrCutStart - 1) , j = 0; i < arrCutFinal; i++,j++) {
                notSortingArr[j] = numbers[i];
            }
            Arrays.sort(notSortingArr);

            answer[index] = notSortingArr[answerIndex - 1];
            index++;
        }

        return answer;
    }
}
