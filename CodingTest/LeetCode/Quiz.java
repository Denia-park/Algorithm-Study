package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

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
        final Deque<Integer> dq = Arrays.stream(piles)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int answer = 0;

        while (!dq.isEmpty()) {
            final int maxValue = dq.pollLast();
            final int secondMaxValue = dq.pollLast();
            final int minValue = dq.pollFirst();

            answer += secondMaxValue;
        }

        return answer;
    }
}
