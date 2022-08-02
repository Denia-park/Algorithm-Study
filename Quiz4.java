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
                {0,0,0,0,0,0,1,1,1,0},
        };
        int[][] target3 = {
                {1,0,1,0,1,0,0,0,0,0},
        };

//        System.out.println(solution(quiz1, target1) == 5);
//        System.out.println(solution(quiz2, target2) == -1);
        System.out.println(solution(quiz3, target3));
    }

    static int[][] startBoard;

    static public int solution ( int[][] beginning, int[][] target){
        int[] answer = new int[2];
        int[] answer1 = new int[2];

        int whileCount = 0;
        int i = 0;
        //행 , 열 중에 어떤 것을 먼저 순회할지 정할 변수
        int odd = 0;

        //사각형의 왼쪽면 , 윗쪽면 순회하는 Loop
        for (int j = 0; j < answer.length; j++) {
            odd = j;
            whileCount = 0;

            startBoard = new int[beginning.length][beginning[0].length];
            for(int jj=0; jj<startBoard.length; jj++){
                System.arraycopy(beginning[jj], 0, startBoard[jj], 0, beginning[0].length);
            }

            //2개의 사각형이 일치할떄까지 While문 순회
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

                if(whileCount > 20){
                    System.out.println("해당 알고리즘은 실패 ㅠㅠ");
                    answer[j] = -1;
                    break;
                }
            }
        }

        //사각형의 오른쪽면 , 아래쪽면 순회하는 Loop
        for (int j = 0; j < answer1.length; j++) {
            odd = j;
            whileCount = 0;

            startBoard = new int[beginning.length][beginning[0].length];
            for(int jj=0; jj<startBoard.length; jj++){
                System.arraycopy(beginning[jj], 0, startBoard[jj], 0, beginning[0].length);
            }

            //2개의 사각형이 일치할떄까지 While문 순회
            while(!Arrays.deepEquals(startBoard, target)){
                if(odd == 0){
                    //row 비교
                    for (i = 0; i < beginning.length; i++) {
                        if(startBoard[i][beginning[0].length - 1] != target[i][beginning[0].length - 1]){
                            reverseRow(i);
                            answer1[j]++;
                        }
                    }
                    odd = 1;
                }else{
                    //column 비교
                    for (i = 0; i < beginning[0].length; i++) {
                        if(startBoard[beginning.length - 1][i] != target[beginning.length - 1][i]){
                            reverseColumn(i);
                            answer1[j]++;
                        }
                    }
                    odd = 0;
                }

                whileCount ++;

                if(whileCount > 20){
                    System.out.println("해당 알고리즘은 실패 ㅠㅠ");
                    answer1[j] = -1;
                    break;
                }
            }
        }

        //사각형을 완전 순회 하면서 최솟값을 찾아야함
        //1. 왼쪽 면 순회 + 윗쪽 면 순회 + 오른쪽 면 순회 + 아래쪽 면 순회
        //2. 윗쪽 면 순회 + 왼쪽 면 순회 + 오른쪽 면 순회 + 아래쪽 면 순회
        //3. 왼쪽 면 순회 + 윗쪽 면 순회 + 아래쪽 면 순회 + 오른쪽 면 순회
        //4. 윗쪽 면 순회 + 왼쪽 면 순회 + 아래쪽 면 순회 + 오른쪽 면 순회

        //위에서 나온 4가지 케이스 중에서 가장 최솟값을 return 해주면 된다.
        return Math.min(Math.min(answer[0], answer[1]), Math.min(answer1[0], answer1[1]));
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
