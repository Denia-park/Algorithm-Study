package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.minimumOneBitOperations(4) == 7);
    }
}

class Solution {
    public int minimumOneBitOperations(final int n) {
        return minimumOneBitOperations(n, 0);
    }

    public int minimumOneBitOperations(final int n, final int res) {
        if (n == 0) return res;
        int b = 1;
        while ((b << 1) <= n)
            b = b << 1;
        return minimumOneBitOperations((b >> 1) ^ b ^ n, res + b);
    }
}
