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
        Stack<String> stack = new Stack<>();

        dfs("");

        List<String> expressionList =  splitExpression(expression);

        for (String combinedOperator : combinedOperators) {
            List<String> inputList = expressionList;
            List<String> resultList = new ArrayList<>();
            int operatorIndex = 0;
            while(true){
                for (int i = 0; i < inputList.size(); i++) {
                    String tempStr = inputList.get(i);

                    if(isOperator(tempStr) && tempStr.equals(combinedOperator.substring(operatorIndex, operatorIndex + 1))){
                        String removeValue = inputList.get(i - 1);
                        resultList.remove(resultList.size() - 1);
                        switch (tempStr) {
                            case "+":
                                resultList.add(String.valueOf(Long.parseLong(removeValue) + Long.parseLong(inputList.get(i + 1))));
                                break;
                            case "*":
                                resultList.add(String.valueOf(Long.parseLong(removeValue) * Long.parseLong(inputList.get(i + 1))));
                                break;
                            case "-":
                                resultList.add(String.valueOf(Long.parseLong(removeValue) - Long.parseLong(inputList.get(i + 1))));
                                break;
                        }
                        i = i + 1;
                    }else{
                        resultList.add(tempStr);
                    }
                }
                if(resultList.size() == 1){
                    answer = Math.max(answer, Math.abs(Long.parseLong(resultList.get(0))));
                    break;
                }
                inputList = resultList;
                resultList = new ArrayList<String>();
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
