package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.kInversePairs(3, 0));
        System.out.println("1 : " + solution.kInversePairs(3, 1));
    }
}

class Solution {
    public int kInversePairs(final int n, final int k) {
        final int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x <= Math.min(j, i - 1); x++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1000000007;
                }
            }
        }

        return dp[n][k];
    }
}
