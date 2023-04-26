package CodingTest.Programmers;

//행렬의 곱셈
// 1 4     3 3     15 15
// 3 2     3 3     15 15
// 4 1             15 15

// 3X2     2X2     3X2
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int answerRow = arr1.length;
        int answerCol = arr2[0].length;

        int[][] answer = new int[answerRow][answerCol];

        for (int row = 0; row < answerRow; row++) {
            for (int col = 0; col < answerCol; col++) {
                answer[row][col] = multiply(arr1, arr2, row, col);
            }
        }

        return answer;
    }

    private int multiply(int[][] arr1, int[][] arr2, int row, int col) {
        int startRow = 0;
        int startCol = 0;

        int limit = arr1[0].length;

        int answer = 0;
        while (startRow < limit) {
            //arr1은 row 고정, col 증가
            int arr1Val = arr1[row][startCol];
            //arr2은 row 변경, col 고정
            int arr2Val = arr2[startRow][col];

            answer += arr1Val * arr2Val;
            startRow++;
            startCol++;
        }

        return answer;
    }
}
