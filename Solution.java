//정답 참고
//https://minhamina.tistory.com/147

//반례
//Input : 856 -> Output : 100

class Solution {
    final int DIVIDE_VALUE = 10007;
    long[][] dp;

    public void solution(int size) {
        dp = new long[1002][10];

        //1자리 수 초기화
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= size + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += (dp[i - 1][k] % DIVIDE_VALUE);
                }
            }
        }

        System.out.println(dp[size + 1][0] % DIVIDE_VALUE);
    }
}
