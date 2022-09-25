// 정답 코드 참고 : https://wonillism.github.io/programmers/Programmers-3xn-tiling/

class Solution {
    public long solution(int n) {
        long[] memo = new long[5001];

        memo[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            long cal1 = 0;
            long cal2 = 0;

            cal1 = 3 * memo[i - 2];

            for (int j = i-4; j > 0 ; j -= 2) {
                cal2 += (2 * memo[j]);
            }
            memo[i] = (cal1 + cal2 + 2)% 1_000_000_007;
        }

        return memo[n];
    }
}
