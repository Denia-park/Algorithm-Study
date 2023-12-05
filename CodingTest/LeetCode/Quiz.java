package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(7));
        System.out.println(solution.numberOfMatches(14));
    }
}

class Solution {
    public int numberOfMatches(int n) {
        int count = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count += n;
            } else {
                n = ((n - 1) / 2) + 1;
                count += n - 1;
            }
        }

        return count;
    }
}
