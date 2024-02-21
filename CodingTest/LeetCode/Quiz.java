package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.rangeBitwiseAnd(5, 7));
        System.out.println(solution.rangeBitwiseAnd(0, 0));
        System.out.println(solution.rangeBitwiseAnd(1, 2147483647));
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;

        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            cnt++;
        }

        return (left << cnt);
    }
}
