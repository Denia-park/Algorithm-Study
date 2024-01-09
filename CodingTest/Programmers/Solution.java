package CodingTest.Programmers;

class Solution {
    public int solution(final int[][] triangle) {
        final int length = triangle.length;
        int maxValue = -1;

        final int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < length; row++) {
            dp[row][0] = dp[row - 1][0] + triangle[row][0];

            for (int col = 1; col <= row; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row - 1][col - 1]) + triangle[row][col];
                maxValue = Math.max(maxValue, dp[row][col]);
            }
        }

        return maxValue;
    }
}
