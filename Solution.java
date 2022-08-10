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
        //answer를 Integer[] 로 설정한 이유 : answerList.toArray(answer) 를 쓰기 위해서
        Integer[] answer = {};
        //정답을 담아두기 위해서 List 생성
        List<Integer> answerList = new ArrayList<Integer>();
        //앞에서부터 처리해야 하므로 FIFO인 Queue 생성
        Queue<Integer> answerQueue = new LinkedList<>();
        //전체적인 처리과정을 알 수 있게 Index 변수 생성
        int progressIndex = 0;
        //총 몇개가 처리 되었는지 알 수 있게 Count 변수 생성
        int totalCount = 0;

        // progresses의 길이 만큼 전체 작업이 처리 되지 않았으면 계속해서 while 문을 돈다.
        while (totalCount != progresses.length) {
            //오늘 처리한 작업량을 계산할 변수
            int todayCompleteCount = 0;

            //기존에 사용했던 Queue 내용을 초기화
            answerQueue.clear();

            //progresses의 내용을 하루 하루 지남에 따라 업데이트 , Queue 에 넣어준다.
            for (int i = progressIndex; i < progresses.length; i++) {
                progresses[i] = progresses[i] + speeds[i];
                answerQueue.add(progresses[i]);
            }

            //Queue에 넣어준 데이터를 하나 하나 꺼내면서 값을 확인한다.
            while (!answerQueue.isEmpty()) {
                //작업량이 100 넘었으면 poll 해주고 오늘 작업량 + 1 , progressIndex 를 + 1 해준다.
                if(answerQueue.peek() >= 100){
                    answerQueue.poll(); // 완료된 작업은 꺼낸다.
                    todayCompleteCount++; // 오늘 작업량 + 1
                    progressIndex++; // progressIndex + 1
                }
                // 작업이 100프로가 아니면 break
                else{
                    break;
                }
            }

            //오늘 작업량이 0개가 아니면 answerList 에 추가해준다. , 전체 작업량도 내용으 업데이트
            if(todayCompleteCount != 0){
                answerList.add(todayCompleteCount); // answerList 에 내용 추가
                totalCount = totalCount + todayCompleteCount; // 전체 작업량도 내용을 업데이트
            }
        }

        // answerList 를 Array 로 만들어서 반환
        return answerList.toArray(answer);
    }
}
