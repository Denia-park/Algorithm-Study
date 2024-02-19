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
    public boolean isPowerOfTwo(final int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
