package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        final int[][] matrix = {{1, 2}, {3, 4}};
//        final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        solution.rotate(matrix);

        final int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        solution.rotate(matrix2);
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        final int rowMax = matrix.length;
        final int colMax = matrix[0].length;

        int[][] matrix2 = new int[rowMax][colMax];

        for (int row = 0; row < matrix2.length; row++) {
            System.arraycopy(matrix[row], 0, matrix2[row], 0, matrix[row].length);
        }

        for (int count = 0; count < rowMax / 2; count++) {
            //바깥에서부터 시작
            final int rowStartIdx = count;
            final int colStartIdx = count;

            final int rowMaxIdx = matrix.length - 1 - count;
            final int colMaxIdx = matrix[0].length - 1 - count;

            //row 시작 -> col 끝 | 시작에서부터
            for (int col = colStartIdx; col <= colMaxIdx; col++) {
                matrix2[col][colMaxIdx] = matrix[rowStartIdx][col];
            }

            //col 끝 -> row 끝 | 시작에서부터
            for (int row = rowStartIdx; row <= rowMaxIdx; row++) {
                matrix2[rowMaxIdx][colMaxIdx - row + count] = matrix[row][colMaxIdx];
            }

            //row 끝 -> col 시작 | 끝에서부터
            for (int col = colMaxIdx; col >= colStartIdx; col--) {
                matrix2[col][colStartIdx] = matrix[rowMaxIdx][col];
            }

            //col 시작 -> row 시작 | 끝에서부터
            for (int row = rowMaxIdx; row >= rowStartIdx; row--) {
                matrix2[rowStartIdx][colMaxIdx - row + count] = matrix[row][colStartIdx];
            }
        }

        for (int row = 0; row < matrix2.length; row++) {
            System.arraycopy(matrix2[row], 0, matrix[row], 0, matrix2[row].length);
        }
    }
}
