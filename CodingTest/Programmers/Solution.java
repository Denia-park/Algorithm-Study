package CodingTest.Programmers;

import java.util.Stack;

class Solution {
    public String solution(final String number, int k) {
        final Stack<Integer> stack = new Stack<>();

        final int[] nums = getNums(number);

        for (final int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num && 0 < k) {
                stack.pop();
                k--;
            }

            stack.push(num);
        }

        for (int i = k; i > 0; i--) {
            stack.pop();
        }

        final StringBuilder sb = new StringBuilder();
        for (final Integer val : stack) {
            sb.append(val);
        }

        return sb.toString();
    }

    private int[] getNums(final String number) {
        final char[] charArray = number.toCharArray();
        final int[] tempNums = new int[number.length()];

        for (int i = 0; i < charArray.length; i++) {
            tempNums[i] = charArray[i] - '0';
        }

        return tempNums;
    }
}
