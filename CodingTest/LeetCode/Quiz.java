package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.findPaths(
                2,
                2,
                2,
                0,
                0
        ));
        System.out.println("2 : " + solution.findPaths(
                1,
                3,
                3,
                0,
                1
        ));
    }
}

/*
아이디어
- DFS로 이동하면서 거리 더하기

시간복잡도
- O(mnN)

자료구조
-
 */

class Solution {
    static final int MOD = (int) (Math.pow(10, 9) + 7);
    int maxRow;
    int maxCol;

    int[][] directions = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int findPaths(final int m, final int n, final int maxMove, final int startRow, final int startColumn) {
        maxRow = m;
        maxCol = n;
        final int[][][] dp = new int[maxRow][maxCol][maxMove + 1];

        initDpArray(dp);

        return dfs(startRow, startColumn, maxMove, dp);
    }

    private void initDpArray(final int[][][] dp) {
        for (final int[][] rows : dp) {
            for (final int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
    }

    private int dfs(final int curRow, final int curCol, final int curMoveCount, final int[][][] dp) {
        if (isOutOfBoundary(curRow, curCol)) return 1;
        if (curMoveCount == 0) return 0;

        final int dpVal = dp[curRow][curCol][curMoveCount];
        if (dpVal >= 0) return dpVal;

        int sumVal = 0;

        for (final int[] direction : directions) {
            final int nextRow = curRow + direction[0];
            final int nextCol = curCol + direction[1];
            final int nextCount = curMoveCount - 1;

            sumVal = (sumVal + (dfs(nextRow, nextCol, nextCount, dp) % MOD)) % MOD;
        }

        dp[curRow][curCol][curMoveCount] = sumVal;

        return sumVal;
    }

    public boolean isOutOfBoundary(final int row, final int col) {
        return row < 0 || row >= maxRow || col < 0 || col >= maxCol;
    }
}
