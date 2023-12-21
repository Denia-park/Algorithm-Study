package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(final long n) {
        final String str = String.valueOf(n);
        final Deque<Character> stack = new ArrayDeque<>();

        for (final char ch : str.toCharArray()) {
            stack.push(ch);
        }

        final int[] answer = new int[stack.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Character.getNumericValue(stack.pop());
        }

        return answer;
    }
}
