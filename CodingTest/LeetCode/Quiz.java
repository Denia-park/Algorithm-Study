package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(new Food("abc", "B", 1).equals(new Food("abc", "B", 2)));

        System.out.println(solution.maxScore("011101"));
        System.out.println(solution.maxScore("00111"));
        System.out.println(solution.maxScore("1111"));
    }
}

class Solution {
    public int maxScore(final String s) {
        int oneCount = 0;

        for (int i = 1; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (ch == '1') {
                oneCount++;
            }
        }

        int zeroCount = s.charAt(0) == '0' ? 1 : 0;
        int maxScore = Math.max(0, zeroCount + oneCount);

        for (int i = 1; i < s.length() - 1; i++) {
            final char ch = s.charAt(i);

            if (ch == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }

            maxScore = Math.max(maxScore, zeroCount + oneCount);
        }

        return maxScore;
    }
}
