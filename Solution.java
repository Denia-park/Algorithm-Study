//정답 참고
//https://luv-n-interest.tistory.com/1423
class Solution {
    int[][][] dp;

    public long solution(int scvNum, int[] scvs) {
        dp = new int[61][61][61];
        initArray(dp);

        return calculateCount(scvs[0], scvs[1], scvs[2]);
    }

    private void initArray(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }

    private int calculateCount(int a, int b, int c) {
        if (a < 0) {
            return calculateCount(0, b, c);
        }

        if (b < 0) {
            return calculateCount(a, 0, c);
        }

        if (c < 0) {
            return calculateCount(a, b, 0);
        }

        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }

        if (dp[a][b][c] != -1) {
            return dp[a][b][c];
        }

        dp[a][b][c] = Integer.MAX_VALUE;

        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 9, b - 3, c - 1) + 1);
        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 9, b - 1, c - 3) + 1);
        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 3, b - 9, c - 1) + 1);
        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 1, b - 9, c - 3) + 1);
        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 3, b - 1, c - 9) + 1);
        dp[a][b][c] = Math.min(dp[a][b][c], calculateCount(a - 1, b - 3, c - 9) + 1);

        return dp[a][b][c];
    }
}

