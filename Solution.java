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
            sort(notSortingArr,0, notSortingArr.length -1, true);
//            sort(notSortingArr,false);
            System.out.println(Arrays.toString(notSortingArr));

            answer[index] = notSortingArr[answerIndex - 1];
            index++;
        }

        return answer;
    }

    //퀵정렬
    //가장 많이 사용되는 정렬 알고리즘
    //대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
    //퀵정렬은 기준을 설정한 다음 큰 수 와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작
    //이러한 교환을 위한 기준을 '피벗' 이라고 한다.
    //퀵 정렬의 평균 시간 복잡도 O(NlogN)이고 , 최악의 경우 O(N^2)이다.

    static private void sort(int[] arr, int start, int end, boolean ascending) {
        //원소가 1개인 경우 종료한다.
        if (start >= end) {
            return;
        }

        int pivot = start; //피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;

        while (left <= right) {

            //피벗보다 큰 데이터를 찾을 때 까지 반복
            while(left <= end && arr[left] <= arr[pivot])
                left = left + 1;

            //피벗보다 작은 데이터를 찾을 때 까지 반복
            while(right > start && arr[right] >= arr[pivot])
                right = right - 1;

            //엇갈렸다면 작은 데이터와 피벗을 교체
            //right가 작은 데이터가 되는 이유 : 멈췄다는 거는 작으니까 멈췄다 라는 의미. , 중간에 안 멈추고 start까지 갔다는 것은 피벗보다 작은 데이터가 없다는 뜻이므로 피벗이랑 right를 서로 교환한다. (본인과 본인의 교환) => 다음 퀵소트 재귀함수에서 해당 데이터는 고정된다.
            if(left > right){
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
            //엇갈리지 않았다면 작은 데이터 와 큰 데이터를 교체
            else{
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }

            sort(arr, start, right - 1,true);
            sort(arr, right + 1, end, true);
        }

    }
}

