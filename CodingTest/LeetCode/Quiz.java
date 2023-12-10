package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.transpose(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,2,3],[4,5,6],[7,8,9]]"))));
        System.out.println(Arrays.deepToString(solution.transpose(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,2,3],[4,5,6]]"))));
    }
}

class Solution {
    public int[][] transpose(final int[][] matrix) {
        final int originRowNum = matrix.length;
        final int originColNum = matrix[0].length;

        final int newRowNum = originColNum;
        final int newColNum = originRowNum;

        final int[][] newMatrix = new int[newRowNum][newColNum];

        for (int row = 0; row < originRowNum; row++) {
            for (int col = 0; col < originColNum; col++) {
                newMatrix[col][row] = matrix[row][col];
            }
        }

        return newMatrix;
    }
}
