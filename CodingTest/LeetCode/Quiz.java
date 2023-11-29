package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11) == 3);
    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }

        return ones;
    }
}
