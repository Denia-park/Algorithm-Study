package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
    }
}

class Solution {
    public int numSquares(final int n) {
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        //Bottom-up Calculate
        for (int i = 1; i <= n; i++) {
            int minValue = Integer.MAX_VALUE;
            final int sqrt = (int) Math.sqrt(i);

            for (int j = 1; j <= sqrt; j++) {
                minValue = Math.min(minValue, dp[i - (j * j)] + 1);
            }

            dp[i] = minValue;
        }

        return dp[n];
    }
}
