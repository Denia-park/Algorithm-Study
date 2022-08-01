package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static public void main(String[] args) {
        int[] quiz1 = { 1, 1, 1, 1, 1 };
        int quizTarget1 = 3;
        int[] quiz2 = { 4, 1, 2, 1 };
        int quizTarget2 = 4;

        System.out.println(solution(quiz1, quizTarget1) == 5);
        System.out.println(solution(quiz2, quizTarget2) == 2);
    }

    //bfs 에서 값을 계산할떄 사용이 되어야 하므로 전역변수로 설정
    static int[] numbers;

    static public int solution(int[] quizNumbers, int target) {
        int answer = 0;
        numbers = quizNumbers;
        //너비 우선 탐색으로 진행을 할때 visited를 확인해야 하는데 index를 사용해서 대신 확인 , 처음에는 0으로 설정
        int index = 0;

        answer = bfs(index, target);

        return answer;
    }

    private static int bfs(int index, int target) {
        //answer 에 값을 넘기기 전에 임시로 값을 가지고 있을 임시 변수
        int tempAnswer = 0;
        //너비 우선 탐색시에 사용되는 계산을 마무리 지을 최종 인덱스
        final int FINAL_INDEX = numbers.length - 1;

        //BFS를 수행할때 필요한 Queue를 생성
        Queue<Number> queue = new LinkedList<Number>();

        queue.add(new Number(numbers[index], index));
        queue.add(new Number(-numbers[index], index));

        while (!queue.isEmpty()) {
            Number tempNumber = queue.poll();

            //Visited 확인
            if(tempNumber.index == FINAL_INDEX){
                if (tempNumber.value == target) {
                    tempAnswer++;
                }
            }else{
                tempNumber.index += 1;
                queue.add(new Number(tempNumber.value + numbers[tempNumber.index], tempNumber.index));
                queue.add(new Number(tempNumber.value - numbers[tempNumber.index], tempNumber.index));
            }
        }

        return tempAnswer;
    }
}

class Number {
    int value;
    int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
