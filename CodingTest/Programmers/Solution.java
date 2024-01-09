package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final int[][] triangle) {
        final int length = triangle.length;

        final int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < dp.length; row++) {
            for (int col = 0; col < row + 1; col++) {
                final int curValue = triangle[row][col];
                final int prevRowValue = dp[row - 1][col];

                if (col == 0) {
                    dp[row][col] = prevRowValue + curValue;
                    continue;
                }

                final int diagonalPrevRowValue = dp[row - 1][col - 1];

                dp[row][col] = Math.max(prevRowValue, diagonalPrevRowValue) + curValue;
            }
        }

        return Arrays.stream(dp[length - 1]).max().getAsInt();
    }
}
