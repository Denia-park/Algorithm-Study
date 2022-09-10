package com.company;

// 참조 : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%82%BC%EA%B0%81-%EB%8B%AC%ED%8C%BD%EC%9D%B4-Java

class Solution {
    //삼각형을 그리기 위해서 2차원 좌표계를 설정
    int[][] coordinates;
    //해당하는 좌표가 올바른 좌표인지 확인할때 사용할 변수 설정
    int maxIndex;
    public int[] solution(int n) {
        //2차원 좌표계 초기화
        coordinates = new int[n][n];
        //해당 변수 n으로 초기화
        maxIndex = n;
        //채워져야 하는 최고 값을 maxValue 로 설정
        int maxValue = 0;
        //방향을 설정
        int direction = 1; // 1 : 아래 , 2: 오른쪽 , 3: 위로
        //maxValue 를 구하기 위해서 1~n 까지 모두 더함
        for (int i = 1; i <= n; i++) {
            maxValue += i;
        }

        //answer 를 초기화
        int[] answer = new int[maxValue];

        //처음부터 채울 값을 index로 두고 1로 초기화
        int index = 1;
        //2차원 좌표계에서 사용할 row, col 설정
        int row = -1 , col = 0;

        //index가 maxValue 값을 넘길때까지 while문을 돈다.
        while (index <= maxValue) {
            //row , col 을 임시로 설정
            int tempRow = row;
            int tempCol = col;
            //방향에 따라서 tempRow , tempCol 의 값을 수정
            if(direction == 1) {
                tempRow++;
            } else if (direction == 2) {
                tempCol++;
            }else if (direction == 3) {
                tempRow--;
                tempCol--;
            }

            //수정한 tempRow, tempCol 값이 올바른 좌표값이 아니라면, 2차원 배열의 값을 업데이트 하지 않고
            //방향을 수정하여 다시 tempRow , tempCol 을 확인해야함
            if(!isRightCoordinates(tempRow, tempCol)){
                if(direction < 3) direction++;
                else direction = 1;

                continue;
            }

            //수정한 tempRow, tempCol 이 올바른 좌표값이 맞다면,
            //row , col 에 해당 값들을 적용
            row = tempRow;
            col = tempCol;

            //row , col 에 맞게 index를 삽입
            coordinates[row][col] = index;
            //index를 삽입했으므로 index 를 증가
            index++;
        }

        //answer 배열을 업데이트 하기 위한 answerIndex 를 설정
        int answerIndex = 0;

        //2중 for문을 돌면서 coordinates 배열을 확인하여 0이 아닌 값만 answer 배열에 업데이트
        for (int tempRow = 0; tempRow < n; tempRow++) {
            for (int tempCol = 0; tempCol < n; tempCol++) {
                int tempAnswerValue = coordinates[tempRow][tempCol];
                //0이 아닌 값만 answer 배열에 업데이트 후 answerIndex 도 업데이트
                if(tempAnswerValue != 0){
                    answer[answerIndex] = tempAnswerValue;
                    answerIndex++;
                }
            }
        }

        return answer;
    }

    //올바른 좌표계 값이 맞는지 확인
        // 0 이상 n 미만이 맞는지 확인
        // 0이 아닌 값이 들어가 있으면 이미 값이 수정 되었으므로 잘못된 방향이다.
    
    private boolean isRightCoordinates(int row , int col) {
        return row >= 0 && row < maxIndex && col >= 0 && col < maxIndex && coordinates[row][col] == 0;
    }
}
