package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}

class Solution {
    List<String> operators = List.of("+", "-", "*", "/");

    public int evalRPN(final String[] tokens) {
        final Deque<Integer> stack = new ArrayDeque<>();

        for (final String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            final int num2 = stack.pop();
            final int num1 = stack.pop();

            switch (token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(num1 / num2);
                    break;
                default:
                    break;
            }
        }

        return stack.pop();
    }
}
