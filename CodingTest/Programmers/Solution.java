package CodingTest.Programmers;

import java.util.*;

class Solution {
    List<String> operators = List.of(
            "+-*",
            "+*-",
            "-+*",
            "-*+",
            "*+-",
            "*-+"
    );

    List<String> operatorString = List.of(
            "+",
            "-",
            "*"
    );

    public long solution(final String expression) {
        long answer = 0;

        final String newExpression = expression.replace("-", ",").replace("*", ",").replace("+", ",");
        final String[] originNumbers = newExpression.split(",");
        final List<String> originOperator = getOriginOperator(expression);

        for (final String operatorPriority : operators) {
            final Deque<String> postfixQueue = new ArrayDeque<>();
            final Stack<String> operatorStack = new Stack<>();

            //postfix로 만들기
            for (int idx = 0; idx < originNumbers.length; idx++) {
                //숫자 넣기
                postfixQueue.addLast(originNumbers[idx]);

                //연산자 넣기
                if (idx < originOperator.size()) {
                    final String curOperator = originOperator.get(idx);

                    if (operatorStack.isEmpty()) {
                        operatorStack.push(curOperator);
                        continue;
                    }

                    while (!operatorStack.isEmpty()) {
                        final String peekOperator = operatorStack.peek();
                        final int peekOperatorIndex = operatorPriority.indexOf(peekOperator);
                        final int curOperatorIndex = operatorPriority.indexOf(curOperator);

                        if (peekOperatorIndex < curOperatorIndex) {
                            break;
                        }

                        final String popOperator = operatorStack.pop();
                        postfixQueue.addLast(popOperator);
                    }

                    operatorStack.push(curOperator);
                }
            }

            while (!operatorStack.isEmpty()) {
                postfixQueue.addLast(operatorStack.pop());
            }

            final Stack<Integer> calculateStack = new Stack<>();
            while (!postfixQueue.isEmpty()) {
                final String popped = postfixQueue.pop();

                //연산자 아니면 Stack에 넣기
                if (!operatorString.contains(popped)) {
                    calculateStack.push(Integer.valueOf(popped));
                    continue;
                }

                //연산자이면 계산
                final int value2 = calculateStack.pop();
                final int value1 = calculateStack.pop();
                int answerValue = 0;

                switch (popped) {
                    case "+":
                        answerValue = value1 + value2;
                        break;
                    case "-":
                        answerValue = value1 - value2;
                        break;
                    case "*":
                        answerValue = value1 * value2;
                        break;
                }

                calculateStack.push(answerValue);
            }

            answer = Math.max(answer, Math.abs(calculateStack.pop()));
        }

        return answer;
    }

    private List<String> getOriginOperator(final String expression) {
        final List<String> originOperators = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            final char c = expression.charAt(i);

            if (c == '-' || c == '*' || c == '+') {
                originOperators.add(String.valueOf(c));
            }
        }

        return originOperators;
    }
}
