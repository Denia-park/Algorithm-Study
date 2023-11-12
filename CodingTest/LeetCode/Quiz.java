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
    private int maxSize;

    public void rotate(int[][] matrix) {
        maxSize = matrix.length;

        int[][] matrix2 = new int[maxSize][maxSize];

        for (int row = 0; row < matrix2.length; row++) {
            System.arraycopy(matrix[row], 0, matrix2[row], 0, matrix[row].length);
        }

        for (int count = 0; count < maxSize / 2; count++) {
            //바깥에서부터 시작
            final int startIdx = count;
            final int endIdx = maxSize - 1 - count;

            //row 시작 -> col 끝 | 시작에서부터
            for (int col = startIdx; col <= endIdx; col++) {
                matrix2[col][endIdx] = matrix[startIdx][col];
            }

            //col 끝 -> row 끝 | 시작에서부터
            for (int row = startIdx; row <= endIdx; row++) {
                matrix2[endIdx][endIdx - row + count] = matrix[row][endIdx];
            }

            //row 끝 -> col 시작 | 끝에서부터
            for (int col = endIdx; col >= startIdx; col--) {
                matrix2[col][startIdx] = matrix[endIdx][col];
            }

            //col 시작 -> row 시작 | 끝에서부터
            for (int row = endIdx; row >= startIdx; row--) {
                matrix2[startIdx][endIdx - row + count] = matrix[row][startIdx];
            }
        }

        for (int row = 0; row < matrix2.length; row++) {
            System.arraycopy(matrix2[row], 0, matrix[row], 0, matrix2[row].length);
        }
    }
}
