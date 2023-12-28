package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    List<List<String>> operatorPriorities = List.of(
            List.of("+", "-", "*"),
            List.of("+", "*", "-"),
            List.of("-", "+", "*"),
            List.of("-", "*", "+"),
            List.of("*", "+", "-"),
            List.of("*", "-", "+")
    );

    public long solution(final String expression) {
        long answer = 0;

        final String[] originNumbers = getOriginNumbers(expression);
        final List<String> originOperator = getOriginOperator(expression);

        for (final List<String> operatorPriority : operatorPriorities) {
            final Deque<String> postfixQueue = calculatePostfixQueue(operatorPriority, originNumbers, originOperator);

            answer = Math.max(answer, Math.abs(calculateAnswer(postfixQueue)));
        }

        return answer;
    }

    private String[] getOriginNumbers(final String expression) {
        return expression.replace("-", ",")
                .replace("*", ",")
                .replace("+", ",")
                .split(",");
    }

    private List<String> getOriginOperator(final String expression) {
        final List<String> originOperators = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            final char ch = expression.charAt(i);

            if (ch == '-' || ch == '*' || ch == '+') {
                originOperators.add(String.valueOf(ch));
            }
        }

        return originOperators;
    }

    private Deque<String> calculatePostfixQueue(final List<String> operatorPriority, final String[] originNumbers, final List<String> originOperator) {
        final Deque<String> postfixQueue = new ArrayDeque<>();
        final Deque<String> operatorStack = new ArrayDeque<>();

        //postfix로 만들기
        for (int idx = 0; idx < originNumbers.length; idx++) {
            //숫자 넣기
            postfixQueue.addLast(originNumbers[idx]);

            //연산자 넣기
            if (idx < originOperator.size()) {
                final String curOperator = originOperator.get(idx);

                while (!operatorStack.isEmpty()) {
                    final String peekOperator = operatorStack.peek();

                    //현재 연산자가 우선순위가 더 높으면 그냥 push, 아니면 다 꺼내서 Queue에 넣기
                    if (operatorPriority.indexOf(peekOperator) < operatorPriority.indexOf(curOperator)) {
                        break;
                    }

                    postfixQueue.addLast(operatorStack.pop());
                }

                operatorStack.push(curOperator);
            }
        }

        //남은 연산자 다 꺼내서 Queue에 넣기
        while (!operatorStack.isEmpty()) {
            postfixQueue.addLast(operatorStack.pop());
        }

        return postfixQueue;
    }

    private long calculateAnswer(final Deque<String> postfixQueue) {
        final Deque<Long> calculateStack = new ArrayDeque<>();

        while (!postfixQueue.isEmpty()) {
            final String popped = postfixQueue.pop();

            //연산자 아니면 Stack에 넣기
            final List<String> operators = List.of("+", "-", "*");
            if (!operators.contains(popped)) {
                calculateStack.push(Long.valueOf(popped));
                continue;
            }

            //연산자 맞으면 계산
            final long value2 = calculateStack.pop();
            final long value1 = calculateStack.pop();

            switch (popped) {
                case "+":
                    calculateStack.push(value1 + value2);
                    break;
                case "-":
                    calculateStack.push(value1 - value2);
                    break;
                case "*":
                    calculateStack.push(value1 * value2);
                    break;
            }
        }

        return calculateStack.pop();
    }
}
