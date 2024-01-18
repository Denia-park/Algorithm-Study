package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.climbStairs(2));
        System.out.println("2 : " + solution.climbStairs(3));
    }
}

class Solution {
    public int climbStairs(final int n) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
