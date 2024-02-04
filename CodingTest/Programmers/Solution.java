package CodingTest.Programmers;

import java.util.Stack;

class Solution {
    public String solution(final String number, final int k) {
        final Stack<Integer> stack = new Stack<>();

        final int[] nums = new int[number.length()];

        final char[] charArray = number.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            nums[i] = charArray[i] - '0';
        }

        int count = 0;
        for (final int num : nums) {
            while (!stack.isEmpty()) {
                final int peek = stack.peek();

                if (peek < num && count < k) {
                    stack.pop();
                    count++;
                } else {
                    break;
                }
            }

            stack.push(num);
        }

        final StringBuilder sb = new StringBuilder();
        for (final Integer val : stack) {
            sb.append(val);
        }

        return sb.toString();
    }
}
