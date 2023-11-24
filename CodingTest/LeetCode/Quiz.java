package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int answer1 = solution.maxCoins(new int[]{2, 4, 1, 2, 7, 8});
        System.out.println(answer1 + " , " + (answer1 == 9));
        final int answer2 = solution.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});
        System.out.println(answer2 + ", " + (answer2 == 18));
    }
}

class Solution {
    public int maxCoins(final int[] piles) {
        Arrays.sort(piles);
        final ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (final int pile : piles) {
            dq.add(pile);
        }

        int answer = 0;

        while (!dq.isEmpty()) {
            dq.pollLast();
            answer += dq.pollLast();
            dq.pollFirst();
        }

        return answer;
    }
}
