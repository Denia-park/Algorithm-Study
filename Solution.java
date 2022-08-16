package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        int[] quizArr1 = {2, 1, 3, 2};
        int quizInt1 = 2;
        int[] quizArr2 = {1, 1, 9, 1, 1, 1};
        int quizInt2 = 0;

        System.out.println(testSolution.solution(quizArr1, quizInt1));
        System.out.println(testSolution.solution(quizArr2, quizInt2));

    }

    public int solution(int[] priorities, int target) {
        int answer = 0;

        //프린터 인쇄 대기열을 저장해둘 Queue 생성
        Queue<Paper> queue = new LinkedList<Paper>();

        //현재 대기열을 Queue 에 다 집어넣는다.
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Paper(priorities[i], i));
        }

        //우선 순위대로 뽑기 위해서 정렬을 수행
        Integer[] sortedDescPriorities = new Integer[priorities.length]; //Integer 배열 생성
        Arrays.setAll(sortedDescPriorities, index -> priorities[index]); //priorities int[] 를 Integer[]로 변경
        Arrays.sort(sortedDescPriorities, Collections.reverseOrder()); //Integer[] 을 reverseOrder 로 정렬

        //현재 우선순위 몇번째까지 처리되었는지 확인할 Index
        int priorIndex = 0;

        //target에 해당할때 가지 while Loop 를 돈다.
        while(true){
            //Queue에서 poll 해서 값을 꺼낼때 필요한 변수
            Paper headValue = null;

            //queue 가 비어있지 않으면 꺼낸다.
            if(!queue.isEmpty())
                headValue = queue.poll();

            //Queue에서 꺼낸 값이 현재 우선순위에 맞는 인쇄물인지 확인
                //다르면 queue 맨 뒤에 추가
            if(headValue.getPriority() != sortedDescPriorities[priorIndex] ){
                queue.add(headValue);
            }
            //우선순위가 맞으면 우선순위 Index를 1 올린다.
            //인쇄물이 뽑혔으므로 answer를 1 올린다.
            //현재 뽑은 인쇄물의 index가 target가 동일하면 break문을 통해 while을 빠져나온다.
            else{
                priorIndex++;
                answer++;
                if(headValue.getIndex() == target)
                    break;
            }
        }

        return answer;
    }
}

//인쇄물을 나타낼 class
class Paper{
    int priority; //해당 인쇄물 우선순위
    int index; //해당 인쇄물의 Index

    //생성자
    public Paper(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }

    //Getter
    public int getPriority() {
        return priority;
    }

    public int getIndex() {
        return index;
    }
}
