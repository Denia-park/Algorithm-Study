class Solution {
    int[][] dp;

    public int solution(int houseNum, int[][] table) {
        dp = new int[houseNum + 1][3];

        for (int i = 1; i <= houseNum; i++) {
            dp[i][0] += table[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += table[i - 1][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += table[i - 1][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[houseNum][0], Math.min(dp[houseNum][1], dp[houseNum][2]));
    }
}
