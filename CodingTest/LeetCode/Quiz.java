package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(3));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        else if (n == 1) return true;

        if (n > 1) {
            while (n != 1) {
                if (n % 2 == 1) {
                    return false;
                }

                n /= 2;
            }
        } else if (0 < n && n < 1) {
            while (n < 1) {
                n *= 2;
            }
        }

        return n == 1;
    }
}
