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

        int[][] quiz3 = {
                {0,0,0,0,1,0},
                {0,0,0,0,1,0},
                {0,0,0,0,1,0}
        };
        int[][] target3 = {
                {1,0,0,0,0,1},
                {1,0,0,0,0,1},
                {1,0,0,0,0,1}
        };
//        int[][] quiz3 = {
//                {0,0,0},
//                {0,0,0},
//                {0,0,0}
//        };
//        int[][] target3 = {
//                {0,0,0},
//                {0,0,0},
//                {0,0,0}
//        };


//        System.out.println(solution(quiz1, target1) == 5);
//        System.out.println(solution(quiz2, target2) == -1);
        System.out.println(solution(quiz3, target3));
    }

    static int[][] startBoard;

    static public int solution ( int[][] beginning, int[][] target){
        int[] answer = new int[2];

        int whileCount = 0;

        int i = 0;

        int odd = 0;

        for (int j = 0; j < answer.length; j++) {

            odd = j;
            whileCount = 0;

            startBoard = new int[beginning.length][beginning[0].length];
            for(int jj=0; jj<startBoard.length; jj++){
                System.arraycopy(beginning[jj], 0, startBoard[jj], 0, beginning[0].length);
            }

            while(!Arrays.deepEquals(startBoard, target)){
                if(odd == 0){
                    //row 비교
                    for (i = 0; i < beginning.length; i++) {
                        if(startBoard[i][0] != target[i][0]){
                            reverseRow(i);
                            answer[j]++;
                        }
                    }
                    odd = 1;
                }else{
                    //column 비교
                    for (i = 0; i < beginning[0].length; i++) {
                        if(startBoard[0][i] != target[0][i]){
                            reverseColumn(i);
                            answer[j]++;
                        }
                    }
                    odd = 0;
                }

                whileCount ++;

                if(whileCount > 30){
                    System.out.println("해당 알고리즘은 실패 ㅠㅠ");
                    answer[j] = -1;
                    break;
                }
            }
        }

        return Math.min(answer[0], answer[1]);
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
