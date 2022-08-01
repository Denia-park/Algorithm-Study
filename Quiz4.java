package com.company;

import java.util.Arrays;

public class Quiz4 {
    static public void main(String[] args) {
        int[][] quiz1 = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };
        int[][] target1 = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };

        int[][] quiz2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] target2 = {
                {1, 0, 1},
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println(solution(quiz1, target1) == 5);
        System.out.println(solution(quiz2, target2) == -1);
    }

    static int[][] startBoard;

    static public int solution ( int[][] beginning, int[][] target){
        int answer = 0;
        startBoard = beginning;

        int whileCount = 0;

        while(!Arrays.deepEquals(startBoard, target)){
            //row 비교
            for (int i = 0; i < beginning.length; i++) {
                if(beginning[i][0] != target[i][0]){
                    reverseRow(i);
                    answer++;
                }
            }

            //column 비교
            for (int i = 0; i < beginning[0].length; i++) {
                if(beginning[0][i] != target[0][i]){
                    reverseColumn(i);
                    answer++;
                }
            }

            whileCount ++;

            if(whileCount > 10){
                System.out.println("해당 알고리즘은 실패 ㅠㅠ");
                return -1;
            }
        }

        System.out.println(Arrays.deepToString(startBoard));

        return answer;
    }

    //가로줄 뒤집기 메서드
    private static void reverseRow(int row) {
        for (int i = 0; i < startBoard[row].length; i++) {
            startBoard[row][i] = startBoard[row][i] ^ 1;
        }
    }

    //세로줄 뒤집기 메서드
    private static void reverseColumn(int column) {
        for (int i = 0; i < startBoard.length; i++) {
            startBoard[i][column] = startBoard[i][column] ^ 1;
        }
    }
}
