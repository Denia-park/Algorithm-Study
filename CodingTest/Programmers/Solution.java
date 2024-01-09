package CodingTest.Programmers;

class Solution {
    public int solution(final int[][] triangle) {
        final int length = triangle.length;
        int maxValue = Integer.MIN_VALUE;

        final int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < dp.length; row++) {
            dp[row][0] = dp[row - 1][0] + triangle[row][0];

            for (int col = 1; col < row + 1; col++) {
                final int curValue = triangle[row][col];

                final int prevRowValue = dp[row - 1][col];
                final int diagonalPrevRowValue = dp[row - 1][col - 1];

                dp[row][col] = Math.max(prevRowValue, diagonalPrevRowValue) + curValue;
                maxValue = Math.max(maxValue, dp[row][col]);
            }
        }

        return maxValue;
    }
}
