package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.rob(
                new int[]{1, 2, 3, 1}
        ));
        System.out.println("2 : " + solution.rob(
                new int[]{2, 7, 9, 3, 1}
        ));
    }
}

class Solution {
    public int rob(final int[] nums) {
        final int length = nums.length;
        final int[] dp = new int[length + 1];

        dp[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[length];
    }
}
