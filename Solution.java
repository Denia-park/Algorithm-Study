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
//            Arrays.sort(notSortingArr); // 기존 라이브러리 사용
            sort(notSortingArr,true);
            System.out.println(Arrays.toString(notSortingArr));

            answer[index] = notSortingArr[answerIndex - 1];
            index++;
        }

        return answer;
    }

    //선택정렬
    //선택 정렬은 N-1 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 한다.
    //또한 매번 가장 작은 수를 찾기 위해 비교 연산이 필요
    //빅오 표기법 O(N^2)
    static private void sort(int[] arr , boolean ascending){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(ascending) {
                    if(arr[i] > arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                else{
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}

