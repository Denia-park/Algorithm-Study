package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.onesMinusZeros(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[0,1,1],[1,0,1],[0,0,1]]"))));
        System.out.println(Arrays.deepToString(solution.onesMinusZeros(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,1,1],[1,1,1]]"))));
    }
}

class Solution {
    public int[][] onesMinusZeros(final int[][] grid) {
        final int totalRow = grid.length;
        final int totalCol = grid[0].length;

        final int[][] diff = new int[totalRow][totalCol];

        final int[] rowOneCountArr = new int[totalRow];
        for (int row = 0; row < totalRow; row++) {
            final int[] ints = grid[row];

            int tempCount = 0;
            for (final int anInt : ints) {
                if (anInt == 1) {
                    tempCount++;
                }
            }

            rowOneCountArr[row] = tempCount;
        }

        final int[] colOneCountArr = new int[totalCol];
        for (int col = 0; col < totalCol; col++) {
            int tempCount = 0;
            for (int row = 0; row < totalRow; row++) {
                if (grid[row][col] == 1) {
                    tempCount++;
                }
            }

            colOneCountArr[col] = tempCount;
        }

        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {
                final int oneRowCount = rowOneCountArr[row];
                final int oneColCount = colOneCountArr[col];
                diff[row][col] = (oneRowCount + oneColCount) - (totalRow - oneRowCount + totalCol - oneColCount);
            }
        }

        return diff;
    }
}
