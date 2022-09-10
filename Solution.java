package com.company;

// 참조 : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%82%BC%EA%B0%81-%EB%8B%AC%ED%8C%BD%EC%9D%B4-Java

class Solution {
    int[][] coordinates;
    int maxIndex;
    public int[] solution(int n) {
        coordinates = new int[n][n];
        maxIndex = n;
        int maxValue = 0;
        int direction = 1; // 1 : 아래 , 2: 오른쪽 , 3: 위로
        for (int i = 1; i <= n; i++) {
            maxValue += i;
        }
        int[] answer = new int[maxValue];


        int index = 1;
        int row = -1 , col = 0;
        while (index <= maxValue) {
            int tempRow = row;
            int tempCol = col;
            if(direction == 1) {
                tempRow++;
            } else if (direction == 2) {
                tempCol++;
            }else if (direction == 3) {
                tempRow--;
                tempCol--;
            }

            if(!isRightCoordinates(tempRow, tempCol)){
                if(direction < 3) direction++;
                else direction = 1;

                continue;
            }

            row = tempRow;
            col = tempCol;

            coordinates[row][col] = index;
            index++;
        }

        int answerIndex = 0;
        for (int tempRow = 0; tempRow < n; tempRow++) {
            for (int tempCol = 0; tempCol < n; tempCol++) {
                int tempAnswerValue = coordinates[tempRow][tempCol];
                if(tempAnswerValue != 0){
                    answer[answerIndex] = tempAnswerValue;
                    answerIndex++;
                }
            }
        }

        return answer;
    }

    private boolean isRightCoordinates(int row , int col) {
        return row >= 0 && row < maxIndex && col >= 0 && col < maxIndex && coordinates[row][col] == 0;
    }
}
