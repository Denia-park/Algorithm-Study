package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numRollsToTarget(1, 6, 3) == 1);
        System.out.println(solution.numRollsToTarget(2, 6, 7) == 6);
        System.out.println(solution.numRollsToTarget(30, 30, 500) == 222616187);
    }
}

class Solution {
    public static final int MOD = 1_000_000_007;

    public int numRollsToTarget(final int n, final int k, final int target) {
        //주사위 개수를 늘려가면서 dp를 만들자
        final int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        //1번째 주사위부터 계산을 하자.
        for (int diceIdx = 1; diceIdx < n + 1; diceIdx++) {
            for (int targetIdx = 1; targetIdx < target + 1; targetIdx++) {
                for (int numIdx = 1; numIdx < k + 1; numIdx++) {
                    final int restValue = targetIdx - numIdx;

                    if (restValue < 0) {
                        continue;
                    }

                    dp[diceIdx][targetIdx] = (dp[diceIdx][targetIdx] + (dp[diceIdx - 1][restValue] % MOD)) % MOD;
                }
            }
        }

        return dp[n][target];
    }
}
