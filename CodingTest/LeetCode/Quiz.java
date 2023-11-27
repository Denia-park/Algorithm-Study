package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.knightDialer(1));
        System.out.println(solution.knightDialer(2));
        System.out.println(solution.knightDialer(3));
        System.out.println(solution.knightDialer(10));
        System.out.println(solution.knightDialer(3131));
    }
}

class Solution {
    private final int MOD = 1_000_000_000 + 7;

    public int knightDialer(final int n) {
        if (n == 1) {
            return 10;
        }

        long result = 0;

        long[] dialerCount = new long[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1};

        for (int i = 1; i < n - 1; i++) {
            final long[] temp = new long[10];
            for (int j = 0; j < 10; j++) {
                final long count = dialerCount[j];
                if (count == 0) {
                    continue;
                }

                if (j == 0) {
                    temp[4] = (temp[4] % MOD + (count) % MOD) % MOD;
                    temp[6] = (temp[6] % MOD + (count) % MOD) % MOD;
                } else if (j == 1) {
                    temp[6] = (temp[6] % MOD + (count) % MOD) % MOD;
                    temp[8] = (temp[8] % MOD + (count) % MOD) % MOD;
                } else if (j == 2) {
                    temp[7] = (temp[7] % MOD + (count) % MOD) % MOD;
                    temp[9] = (temp[9] % MOD + (count) % MOD) % MOD;
                } else if (j == 3) {
                    temp[4] = (temp[4] % MOD + (count) % MOD) % MOD;
                    temp[8] = (temp[8] % MOD + (count) % MOD) % MOD;
                } else if (j == 4) {
                    temp[0] = (temp[0] % MOD + (count) % MOD) % MOD;
                    temp[3] = (temp[3] % MOD + (count) % MOD) % MOD;
                    temp[9] = (temp[9] % MOD + (count) % MOD) % MOD;
                } else if (j == 6) {
                    temp[0] = (temp[0] % MOD + (count) % MOD) % MOD;
                    temp[1] = (temp[1] % MOD + (count) % MOD) % MOD;
                    temp[7] = (temp[7] % MOD + (count) % MOD) % MOD;
                } else if (j == 7) {
                    temp[2] = (temp[2] % MOD + (count) % MOD) % MOD;
                    temp[6] = (temp[6] % MOD + (count) % MOD) % MOD;
                } else if (j == 8) {
                    temp[1] = (temp[1] % MOD + (count) % MOD) % MOD;
                    temp[3] = (temp[3] % MOD + (count) % MOD) % MOD;
                } else if (j == 9) {
                    temp[2] = (temp[2] % MOD + (count) % MOD) % MOD;
                    temp[4] = (temp[4] % MOD + (count) % MOD) % MOD;
                }
            }

            dialerCount = temp;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 4 || i == 6) {
                result = ((result % MOD) + ((dialerCount[i] * 3) % MOD)) % MOD;
            } else {
                result = ((result % MOD) + ((dialerCount[i] * 2) % MOD)) % MOD;
            }
        }

        return (int) (result % MOD);
    }
}
