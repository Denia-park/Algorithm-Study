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
                    calculate(temp, count, 4, 6);
                } else if (j == 1) {
                    calculate(temp, count, 6, 8);
                } else if (j == 2) {
                    calculate(temp, count, 7, 9);
                } else if (j == 3) {
                    calculate(temp, count, 4, 8);
                } else if (j == 4) {
                    calculate(temp, count, 0, 3, 9);
                } else if (j == 6) {
                    calculate(temp, count, 0, 1, 7);
                } else if (j == 7) {
                    calculate(temp, count, 2, 6);
                } else if (j == 8) {
                    calculate(temp, count, 1, 3);
                } else if (j == 9) {
                    calculate(temp, count, 2, 4);
                }
            }

            dialerCount = temp;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 4 || i == 6) {
                result = (result + ((dialerCount[i] * 3) % MOD)) % MOD;
            } else {
                result = (result + ((dialerCount[i] * 2) % MOD)) % MOD;
            }
        }

        return (int) result;
    }

    private void calculate(final long[] temp, final long count, final int... indexs) {
        for (final int index : indexs) {
            temp[index] = (temp[index] + (count % MOD)) % MOD;
        }
    }
}
