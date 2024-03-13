package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.pivotInteger(8));
        System.out.println(solution.pivotInteger(1));
        System.out.println(solution.pivotInteger(4));
    }
}

class Solution {
    public int pivotInteger(final int n) {
        int totalSum = ((n + 1) * n) / 2;

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            totalSum -= i;
            if (sum == totalSum) {
                return i;
            }

            sum += i;
        }

        return -1;
    }
}
