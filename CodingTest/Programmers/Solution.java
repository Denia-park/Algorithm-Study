package CodingTest.Programmers;

class Solution {
    int[] dp;

    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;


        return getDp(n) % 1234567;
    }

    private int getDp(int n) {
        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = getDp(n - 1) + getDp(n - 2);
            return dp[n];
        }
    }
}
