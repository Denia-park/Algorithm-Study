package CodingTest.Programmers;

import java.util.Stack;

class Solution {
    public int[] solution(final int[] prices) {
        final int length = prices.length;
        final int[] answer = new int[length];

        final Stack<Price> stack = new Stack<>();

        for (int timeIdx = 0; timeIdx < length; timeIdx++) {
            //현재 가격
            final int curPrice = prices[timeIdx];

            //스택이 비어있지 않으면, 스택의 top을 가져온다.
            //그리고 top 가격이 바로 이전 가격 대비해서 가격이 떨어졌으면
            //스택에서 빼고, 현재 시간과 top의 시간 차이를 구해서 answer에 넣는다.
            while (!stack.isEmpty() && (stack.peek().price > curPrice)) {
                final Price topPrice = stack.pop();
                answer[topPrice.startTime] = timeIdx - topPrice.startTime;
            }

            //현재 가격을 스택에 넣는다.
            stack.push(new Price(curPrice, timeIdx));
        }

        while (!stack.isEmpty()) {
            final Price topPrice = stack.pop();
            answer[topPrice.startTime] = length - 1 - topPrice.startTime;
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
