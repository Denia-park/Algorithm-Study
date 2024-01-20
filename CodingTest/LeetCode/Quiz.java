package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.sumSubarrayMins(
                new int[]{3, 1, 2, 4}
        ));
        System.out.println("2 : " + solution.sumSubarrayMins(
                new int[]{11, 81, 94, 43, 3}
        ));
    }
}

class Solution {
    static final int MOD = (int) (Math.pow(10, 9) + 7);

    public int sumSubarrayMins(final int[] arr) {
        final int len = arr.length;

        //start ~ end 까지의 최소 값
        final int[] dp = new int[len + 1];

        int answer = 0;

        //부분 수열의 개수를 늘리면서, 최소 값을 구하기
        for (int startIdx = 1; startIdx <= len; startIdx++) {
            dp[startIdx] = arr[startIdx - 1];
            answer = (answer + dp[startIdx]) % MOD;

            for (int endIdx = startIdx + 1; endIdx <= len; endIdx++) {
                dp[endIdx] = Math.min(dp[endIdx - 1], arr[endIdx - 1]);

                answer = (answer + dp[endIdx]) % MOD;
            }
        }

        return answer;
    }
}
