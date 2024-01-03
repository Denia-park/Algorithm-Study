package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
        System.out.println(solution.numberOfBeams(new String[]{"000", "111", "000"}));
    }
}

class Solution {
    public int numberOfBeams(final String[] bank) {
        int answer = 0;
        int prev = 0;

        for (final String string : bank) {
            final char[] chars = string.toCharArray();
            int count = 0;

            for (final char ch : chars) {
                if (ch == '1') {
                    count++;
                }
            }

            if (count == 0) {
                continue;
            }

            answer += prev * count;
            prev = count;
        }

        return answer;
    }
}
