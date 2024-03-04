package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.bagOfTokensScore(
                new int[]{100}, 50
        ));
        System.out.println(solution.bagOfTokensScore(
                new int[]{200, 100}, 150
        ));
        System.out.println(solution.bagOfTokensScore(
                new int[]{100, 200, 300, 400}, 200
        ));
    }
}

class Solution {
    public int bagOfTokensScore(final int[] tokens, final int power) {
        //tokens를 정렬
        Arrays.sort(tokens);

        int start = 0;
        int end = tokens.length - 1;

        int curPower = power;
        int curScore = 0;

        int maxScore = curScore;

        while (start <= end) {
            final int startVal = tokens[start];
            final int endVal = tokens[end];

            if (curPower >= startVal) {
                curPower -= startVal;
                curScore++;

                maxScore = Math.max(maxScore, curScore);
                start++;
                continue;
            }

            if (curScore > 0) {
                curScore--;

                curPower += endVal;
                end--;
                continue;
            }

            break;
        }

        return maxScore;
    }
}
