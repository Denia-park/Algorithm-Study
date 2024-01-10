package CodingTest.Programmers;

class Solution {
    private static final int MOD = 1000000007;

    public int solution(final int col, final int row, final int[][] puddles) {
        final int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = 1;

        for (final int[] puddle : puddles) {
            final int puddleCol = puddle[0];
            final int puddleRow = puddle[1];

            dp[puddleRow][puddleCol] = -1;
        }

        for (int rowIdx = 1; rowIdx < row + 1; rowIdx++) {
            for (int colIdx = 1; colIdx < col + 1; colIdx++) {
                if (dp[rowIdx][colIdx] == -1) {
                    dp[rowIdx][colIdx] = 0;
                    continue;
                }

                dp[rowIdx][colIdx] = (dp[rowIdx - 1][colIdx] + dp[rowIdx][colIdx - 1]) % MOD;
            }
        }

        return dp[row][col];
    }
}
