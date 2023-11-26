package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
    }
}

class Solution {
    private int answer;

    //각 row의 값들을 이전 줄 기준으로 height를 잰다. (0이 나오면 초기화, 즉 연속된 최대 높이를 구한다.)
    //height를 기준으로 sort를 하고, col을 옮기면서 최대 직사각형 너비값을 구한다.
    public int largestSubmatrix(final int[][] matrix) {
        this.answer = 0;

        //연속된 height 값 구하기
        calculateHeight(matrix);

        //MaxArea 구하기
        for (int row = 0; row < matrix.length; row++) {
            calculateMaxArea(matrix, row);
        }

        return this.answer;
    }

    private void calculateMaxArea(final int[][] matrix, final int rowIdx) {
        Arrays.sort(matrix[rowIdx]);
        for (int colIdx = 0; colIdx < matrix[rowIdx].length; colIdx++) {
            final int curHeight = matrix[rowIdx][colIdx];
            if (curHeight == 0) {
                continue;
            }

            final int width = matrix[rowIdx].length - colIdx;
            this.answer = Math.max(this.answer, width * curHeight);
        }
    }

    private void calculateHeight(final int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    matrix[row][col] = matrix[row - 1][col] + 1;
                } else {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
