class Solution {
    final int DIVIDE_VALUE = 10007;
    int[][] dp;

    public void solution(int size) {
        dp = new int[1001][11];

        //1자리 수 초기화
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            sum += dp[1][i];
        }
        dp[1][10] = sum;

        for (int i = 2; i <= size; i++) {
            dp[i][0] = dp[i - 1][10];
            sum = dp[i][0];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
                sum += dp[i][j];
            }
            dp[i][10] = sum % DIVIDE_VALUE;
        }

        System.out.println(dp[size][10]);
    }
}
