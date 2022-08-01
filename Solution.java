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

        //index가 0인 (=너비가 제일 안쪽인 ) 노드들을 Queue에 추가
        queue.add(new Number(numbers[index], index)); // + 기호일때
        queue.add(new Number(-numbers[index], index)); // - 기호일때

        // Queue가 빌때까지 while문을 수행
        while (!queue.isEmpty()) {
            //Queue에 있는 첫번째 노드를 꺼냄
            Number tempNumber = queue.poll();

            //해당 노드의 Index를 확인
            //Final Index 면 제일 바깥까지 너비를 확인한 경우이므로 Node의 Value가 Target가 일치하는지 확인
            if(tempNumber.index == FINAL_INDEX){
                //Node의 Value가 Target가 일치하는지 확인 => 일치한다면 옳은 경우 이므로 tempAnswer를 ++ 한다.
                if (tempNumber.value == target) {
                    tempAnswer++;
                }
            }else{
                //해당 노드의 Index가 Final Index가 아니면 아직 마지막까지 가지 못했으므로 index를 ++ 해주고 Visted 처리
                tempNumber.index += 1;
                //index를 올려주면서 numbers에 해당하는 값을 더해주거나 빼준다.
                queue.add(new Number(tempNumber.value + numbers[tempNumber.index], tempNumber.index)); // + 기호일때
                queue.add(new Number(tempNumber.value - numbers[tempNumber.index], tempNumber.index)); // - 기호일때
            }
        }
        //while문을 돌면서 다 더해진 tempAnswer를 Return
        return tempAnswer;
    }
}

//BFS 에서 사용할 Number Class를 만들어 준다.
class Number {
    //numbers에 값들을 더하거나 빼서 가지고 있을 value
    int value;
    //해당 Node의 index가 몇인지 확인해줄 index 변수
    int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
