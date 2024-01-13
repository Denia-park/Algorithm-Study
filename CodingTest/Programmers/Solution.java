package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(final String s) {
        final Deque<Character> deque = new ArrayDeque<>();

        final char[] charArr = s.toCharArray();

        for (final char ch : charArr) {
            if (ch == '(') {
                deque.push(ch);
                continue;
            }

            if (deque.isEmpty()) {
                return false;
            }

            final char top = deque.peek();
            if (top == ')') {
                return false;
            }

            deque.pop();
        }

        return deque.isEmpty();
    }
}
