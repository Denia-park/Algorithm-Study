package CodingTest.LeetCode;

import java.util.Stack;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        final int length = s.length();

        for (int i = 0; i < length; i++) {
            final char input = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(input);
                continue;
            }

            final char top = stack.peek();

            if (top == '(' && input == ')') {
                stack.pop();
            } else if (top == '{' && input == '}') {
                stack.pop();
            } else if (top == '[' && input == ']') {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        return stack.isEmpty();
    }
}
