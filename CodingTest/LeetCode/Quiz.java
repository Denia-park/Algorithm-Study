package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("52"));
        System.out.println(solution.largestOddNumber("4206"));
        System.out.println(solution.largestOddNumber("35427"));
        System.out.println(solution.largestOddNumber("7542351161"));
    }
}

class Solution {
    public String largestOddNumber(final String num) {
        int answer = -1;

        for (int right = 0; right < num.length(); right++) {
            if (isOdd(num.charAt(right))) {
                int left = right;

                while (left >= 0) {
                    final String substring = num.substring(left, right + 1);

                    try {
                        final int parseInt = Integer.parseInt(substring);

                        answer = Math.max(answer, parseInt);
                    } catch (final NumberFormatException ignored) {
                        break;
                    }

                    left--;
                }
            }
        }

        return answer == -1 ? "" : String.valueOf(answer);
    }

    private boolean isOdd(final char ch) {
        final int value = ch - '0';

        return value % 2 != 0;
    }
}
