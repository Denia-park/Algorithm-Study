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
        final int[] eachRowLaserCount = new int[bank.length];

        for (int row = 0; row < bank.length; row++) {
            final String string = bank[row];
            int count = 0;

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '1') {
                    count++;
                }
            }

            eachRowLaserCount[row] = count;
        }

        int answer = 0;
        int prev = 0;
        for (final int count : eachRowLaserCount) {
            if (count == 0) {
                continue;
            }

            answer += prev * count;
            prev = count;
        }

        return answer;
    }
}
