package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        int[] numbers = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

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
            for (int i = (arrCutStart - 1), j = 0; i < arrCutFinal; i++, j++) {
                notSortingArr[j] = numbers[i];
            }
//            Arrays.sort(notSortingArr); // 기존 라이브러리 사용
            notSortingArr = sort(notSortingArr,true);
            System.out.println(Arrays.toString(notSortingArr));

            answer[index] = notSortingArr[answerIndex - 1];
            index++;
        }

        return answer;
    }

    //계수정렬
    //특정한 조건이 부합할 때만 사용할 수 있는 매우 빠른 정렬 알고리즘
    //모든 데이터가 양의 정수 , 데이터의 개수 N , 데이터 중 최댓값이 K 일때, 계수 정렬은 최악의 경우에도 수행시간 O(N+K)를 보장한다.
    //계수 정렬은 '데이터의 크기 범위가 제한 되어 정수 형태로 표한할 수 있을 때만 사용'
    //무한한 범위와 실수형 데이터에는 사용할 수 없다.
    //일반적으로 데이터의 최소, 최대의 차가 1_000_000을 넘지 않을 때 효과적
    //이유는 계수 정렬은 모든 범위를 담을 수 있는 크기의 리스트를 선언해야 하기 때문

    static private int[] sort(int[] arr, boolean ascending) {
        //모든 원소의 값이 0보다 크거나 같다고 가정
        int arrSize = 100;

        //모든 범위를 포함하는 리스트 선언 (모든 값은 0으로 초기화)
        int[] count = new int[arrSize];

        for (int k : arr) {
            count[k]++; //각 데이터에 해당하는 인덱스의 값 증가
        }

        int[] answer = new int[arr.length];
        for (int i = 0 , j = 0; i < arrSize; ) {
            if(count[i] != 0){
                answer[j] = i;
                count[i]--;
                j++;
            }else{
                i++;
            }
        }

        return answer;
    }
}

