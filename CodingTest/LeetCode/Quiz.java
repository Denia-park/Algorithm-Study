package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maximumOddBinaryNumber(
                "010"
        ));
        System.out.println(solution.maximumOddBinaryNumber(
                "0101"
        ));
    }
}

class Solution {
    public String maximumOddBinaryNumber(final String s) {
        int one = 0;
        int zero = 0;

        final char[] chars = s.toCharArray();
        final int length = chars.length;
        for (int i = 0; i < length; i++) {
            final char c = chars[i];

            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }

        return "1".repeat(one - 1) + "0".repeat(zero) + "1";
    }
}
