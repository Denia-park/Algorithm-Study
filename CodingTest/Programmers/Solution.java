package CodingTest.Programmers;

import java.util.Stack;

class Solution {
    public int[] solution(final int[] prices) {
        final int length = prices.length;
        final int[] answer = new int[length];

        final Stack<Price> stack = new Stack<>();

        for (int timeIdx = 0; timeIdx < length; timeIdx++) {
            if (stack.isEmpty()) {
                stack.push(new Price(prices[timeIdx], timeIdx));
                continue;
            }

            final Price top = stack.peek();

            if (top.price > prices[timeIdx]) {
                while (!stack.isEmpty() && (stack.peek().price > prices[timeIdx])) {
                    final Price topPrice = stack.pop();
                    answer[topPrice.startTime] = timeIdx - topPrice.startTime;
                }
            } else {
                stack.push(new Price(prices[timeIdx], timeIdx));
            }
        }

        for (int i = 0; i < length - 1; i++) {
            if (answer[i] == 0) {
                answer[i] = length - 1 - i;
            }
        }

        return answer;
    }

    class Price {
        int price;
        int startTime;

        public Price(final int price, final int startTime) {
            this.price = price;
            this.startTime = startTime;
        }
    }
}
