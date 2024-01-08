package CodingTest.Programmers;

class Solution {
    static final int DIV_NUM = 1234567;

    public int solution(final int n) {
        final int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] += (dp[i - 1] + dp[i - 2]) % DIV_NUM;
        }

        return dp[n];
    }
}
