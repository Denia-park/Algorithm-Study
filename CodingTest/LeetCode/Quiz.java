package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger("6777133339"));
    }
}

class Solution {
    public String largestGoodInteger(final String num) {
        int answer = -1;

        char saved = '\0';
        int saveCount = 0;
        for (final char ch : num.toCharArray()) {
            if (saved == ch) {
                saveCount++;

                if (saveCount >= 3) {
                    answer = Math.max(answer, ch - '0');
                }
            } else {
                saveCount = 1;
                saved = ch;
            }
        }

        if (answer == -1) {
            return "";
        }

        return String.valueOf(answer).repeat(3);
    }
}
