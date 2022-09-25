class Solution {
    public long solution(int n) {
        long[] memo = new long[5001];

        memo[2] = 3;
        memo[4] = 11;

        for (int i = 6; i <= n; i += 2) {
            memo[i] =  ((memo[i - 2] * memo[2]) * 2 - (memo[2] * memo[2] * memo[i-4])) % 1_000_000_007;
        }

        return memo[n];
    }
}
