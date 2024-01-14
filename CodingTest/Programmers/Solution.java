package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final String s) {
        int answer = 0;

        final int length = s.length();

        if (isOddLength(length)) {
            return 0;
        }

        final String newStr = s + s;

        //length만큼 반복 -> 왼쪽으로 이동
        //매번 스택이 되는지 확인
        for (int startIdx = 0; startIdx < s.length(); startIdx++) {
            final String checkStr = newStr.substring(startIdx, startIdx + length);

            if (isRightBracket(checkStr)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isOddLength(final int length) {
        return length % 2 != 0;
    }

    private boolean isRightBracket(final String checkStr) {
        final Deque<Character> stack = new ArrayDeque<>();
        final char[] chars = checkStr.toCharArray();

        for (final char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            final char pop = stack.pop();

            if (ch == ')' && pop != '('
                    || ch == '}' && pop != '{'
                    || ch == ']' && pop != '[') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
