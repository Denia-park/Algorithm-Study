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
//            sort(notSortingArr,false);
            System.out.println(Arrays.toString(notSortingArr));

            answer[index] = notSortingArr[answerIndex - 1];
            index++;
        }

        return answer;
    }

    //삽입정렬
    //선택 정렬에 비해 실행 시간 측면에서 더 효율적, 필요할 때만 위치를 바꾸므로 데이터가 거의 정렬되어 있을 때 더욱 효과적
    //삽입 정렬은 특정한 데이터가 적절한 위치에 들어가기 이전에, 그 앞까지의 데이터는 이미 정렬되어 있다고 가정
    //삽입 정렬이 이루워진 원소는 항상 오름차순을 유지
    //삽입 정렬에서 특정한 데이터가 삽입될 위치를 선정할 때 , 삽입될 데이터보다 작은 데이터를 만나면 더 이상 데이터를 살펴볼 필요없이 그 위치에서 멈춤
    //반복문이 2번 중첩 사용 , 시간 복잡도 : 빅오 표기법 O(N^2)
    //★현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작하고 ,최상의 경우 O(N)의 시간복잡도
    //★거의 정렬되어 있는 상황에서는 퀵 정렬 알고리즘보다 강력

    // 3 5 2 7
    static private void sort(int[] arr , boolean ascending){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if(ascending) {
                    if(arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                    else
                        break;
                }
                else{
                    if (arr[j] > arr[j-1]) {
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                    else
                        break;
                }
            }
        }
    }
}

