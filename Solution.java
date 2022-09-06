package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    String[] operators = {"+", "*", "-"};
    boolean[] isVisited;
    List<String> combinedOperators;
    public long solution(String expression) {
        long answer = 0;
        combinedOperators = new ArrayList<>();
        isVisited = new boolean[3];

        dfs("");

        List<String> expressionList =  splitExpression(expression);

        for (String combinedOperator : combinedOperators) {
            List<String> inputList = expressionList;
            Stack<String> stack = new Stack<>();
            int operatorIndex = 0;
            while(true){
                for (int i = 0; i < inputList.size(); i++) {
                    String curStr = inputList.get(i);

                    if (!stack.isEmpty() && isOperator(stack.peek()) && stack.peek().equals(combinedOperator.substring(operatorIndex, operatorIndex + 1))) {
                        String operator = stack.pop();
                        String calculateValue = stack.pop();
                        switch (operator) {
                            case "+":
                                stack.push(String.valueOf(Long.parseLong(calculateValue) + Long.parseLong(curStr)));
                                break;
                            case "*":
                                stack.push(String.valueOf(Long.parseLong(calculateValue) * Long.parseLong(curStr)));
                                break;
                            case "-":
                                stack.push(String.valueOf(Long.parseLong(calculateValue) - Long.parseLong(curStr)));
                                break;
                        }
                    } else {
                        stack.push(curStr);
                    }
                }
                if(stack.size() == 1){
                    answer = Math.max(answer, Math.abs(Long.parseLong(stack.pop())));
                    break;
                }
                inputList = new ArrayList<>(stack);
                stack.clear();
                operatorIndex ++;
            }
        }

        return answer;
    }

    private List<String> splitExpression(String expression) {
        List<String> result = new ArrayList<String>();
        int preIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(isOperator(expression.charAt(i))){
                result.add(expression.substring(preIndex, i));
                result.add(expression.substring(i, i + 1)); // operator
                preIndex = i + 1;
            }
        }
        result.add(expression.substring(preIndex, expression.length()));

        return result;
    }

    private boolean isOperator(char c) {
        return c == '-' || c == '+' || c == '*';
    }
    private boolean isOperator(String  str) {
        return str.equals("-") || str.equals("+") || str.equals("*");
    }

    private void dfs(String str) {
        if(str.length() == 3){
            combinedOperators.add(str);
        }
        else {
            for (int i = 0; i < isVisited.length ; i++) {
                if(!isVisited[i]){
                    isVisited[i] = true;
                    dfs(str + operators[i]);
                    isVisited[i] = false;
                }
            }
        }
    }
}
