package com.company;

import java.util.*;

public class Solution {
    static public void main(String[] args) {
        int[][] quiz1 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};

        System.out.println(Arrays.toString(solution(3,3,quiz1)));
    }

    // Rotate를 수행할 2차원 평면
    static int[][] quizRect;

    static public Integer[] solution(int rows, int columns, int[][] queries) {
        Integer[] answer = {};
        //답을 저장할 List
        List<Integer> answerList = new ArrayList<Integer>();
        //2차원 평면을 정의
        quizRect = new int[rows][columns];

        //2차원 평면 초기화
        int initial = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                quizRect[i][j] = initial++;
            }
        }

        //실제로 changeRect를 수행하며 2차원 평면에서 원소들을 회전 시키고 회전시키면서 구한 최소값을 return 하여
        //answerList 에 추가한다.
        for (int[] query : queries) {
            answerList.add(changeRect(query));
        }

        // answerList 를 배열로 만들어서 Return
        return answerList.toArray(answer);
    }

    static int changeRect(int[] condition){
        //최소값을 구하기 위한 변수 , 처음에 최대값으로 정의
        int minValue = Integer.MAX_VALUE;

        //시작 과 끝 변수들을 정의
        int startRow = condition[0] - 1;
        int endRow = condition[2] - 1;
        int startColumn = condition[1] - 1;
        int endColumn = condition[3] - 1;

        //임시로 값을 저장해둘 변수들을 정의
        int tempCount = 0;
        int tempValue = 0;

        //회전하는 원소들을 저장할 List
        List<Integer> tempList = new ArrayList<Integer>();

        // 4모서리를 주의할 것
        //Rotate 에서 위쪽 면
        int row = startRow;
        int column = startColumn;
        for (; column < endColumn; column++) {
            tempValue = quizRect[row][column]; // 회전할 원소 값들을 tempValue에 저장
            tempList.add(tempValue); // 추후 회전 후에 넣을 값에 쓰기 위해 List에 저장
            minValue = Math.min(minValue, tempValue); // minValue를 구해야 하므로 Math.min() 사용, tempValue 와 기존의 minValue를 비교
            //List에 저장한 값을 이용하여 Rotate 값 적용 , List에 방금 넣은 값을 Rotate의 값으로 쓰면 됨 , 그래서 tempCount를 썼고 거기서 -1 해서 값 대입
            if (tempCount >= 1 ) {
                quizRect[row][column] = tempList.get(tempCount - 1);
            }
            //값을 넣었으므로 tempCount를 1올려야함
            tempCount++;
        }

        //Rotate 에서 오른쪽 면
        row = startRow;
        column = endColumn;
        for (; row < endRow; row++){
            tempValue = quizRect[row][column]; // 회전할 원소 값들을 tempValue에 저장
            tempList.add(tempValue); // 추후 회전 후에 넣을 값에 쓰기 위해 List에 저장
            minValue = Math.min(minValue, tempValue); // minValue를 구해야 하므로 Math.min() 사용, tempValue 와 기존의 minValue를 비교
            //List에 저장한 값을 이용하여 Rotate 값 적용 , List에 방금 넣은 값을 Rotate의 값으로 쓰면 됨 , 그래서 tempCount를 썼고 거기서 -1 해서 값 대입
            if (tempCount >= 1 ) {
                quizRect[row][column] = tempList.get(tempCount - 1);
            }
            //값을 넣었으므로 tempCount를 1올려야함
            tempCount++;
        }

        //Rotate 에서 아래쪽 면
        row = endRow;
        column = endColumn;
        for (; column > startColumn; column--) {
            tempValue = quizRect[row][column]; // 회전할 원소 값들을 tempValue에 저장
            tempList.add(tempValue); // 추후 회전 후에 넣을 값에 쓰기 위해 List에 저장
            minValue = Math.min(minValue, tempValue); // minValue를 구해야 하므로 Math.min() 사용, tempValue 와 기존의 minValue를 비교
            //List에 저장한 값을 이용하여 Rotate 값 적용 , List에 방금 넣은 값을 Rotate의 값으로 쓰면 됨 , 그래서 tempCount를 썼고 거기서 -1 해서 값 대입
            if (tempCount >= 1 ) {
                quizRect[row][column] = tempList.get(tempCount - 1);
            }
            //값을 넣었으므로 tempCount를 1올려야함
            tempCount++;
        }

        //Rotate 에서 왼쪽 면
        row = endRow;
        column = startColumn;
        for (; row > startRow; row--) {
            tempValue = quizRect[row][column]; // 회전할 원소 값들을 tempValue에 저장
            tempList.add(tempValue); // 추후 회전 후에 넣을 값에 쓰기 위해 List에 저장
            minValue = Math.min(minValue, tempValue); // minValue를 구해야 하므로 Math.min() 사용, tempValue 와 기존의 minValue를 비교
            //List에 저장한 값을 이용하여 Rotate 값 적용 , List에 방금 넣은 값을 Rotate의 값으로 쓰면 됨 , 그래서 tempCount를 썼고 거기서 -1 해서 값 대입
            if (tempCount >= 1 ) {
                quizRect[row][column] = tempList.get(tempCount - 1);
            }
            //값을 넣었으므로 tempCount를 1올려야함
            tempCount++;
        }

        //윗쪽 면에서 첫번째 요소 와 두번쨰 요소는 변환이 덜 되었기 때문에 추가적으로 따로 적용해줘야한다.
        quizRect[startRow][startColumn] = tempList.get(tempCount - 1);
        quizRect[startRow][startColumn + 1] = tempList.get(0);

        //계속해서 비교했던 minValue 를 return 한다.
        return minValue;
    }
}
