package CodingTest.Programmers;

class Solution {
    long[] dp;

    public int solution(int n) {
        dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        return (int) (getDp(n) % 1234567);
    }

    private long getDp(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }
}
