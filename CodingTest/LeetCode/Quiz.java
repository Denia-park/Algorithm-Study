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
    final static int MOD = (int) (Math.pow(10, 9) + 7);

    public int sumSubarrayMins(final int[] arr) {
        final int len = arr.length;

        //start ~ end 까지의 최소 값
        final long[][] dp = new long[len + 1][len + 1];

        //최소 값을 구해야 하므로
        //자기 자신의 subarray 제외하고는, 처음엔 다 최대 값 넣기
        for (int start = 0; start <= len; start++) {
            for (int end = 0; end <= len; end++) {
                if (start == 0 || end == 0 || start != end) {
                    dp[start][end] = Integer.MAX_VALUE;
                } else {
                    dp[start][end] = arr[start - 1];
                }
            }
        }

        //부분 수열의 개수를 늘리면서, 최소 값을 구하기
        for (int count = 1; count <= len; count++) {
            for (int start = 1; start <= len; start++) {
                for (int end = start + count; end <= len; end++) {
                    dp[start][end] = Math.min(dp[start][end - 1], dp[end][end]);
                }
            }
        }

        //Integer.MaxValue가 아닌 값들만 구해서 더하면 최소 값이 된다.
        long sum = 0;
        for (final long[] longs : dp) {
            for (final long val : longs) {
                if (val == Integer.MAX_VALUE) {
                    continue;
                }

                sum = (sum + val) % MOD;
            }
        }

        return (int) sum;
    }
}
