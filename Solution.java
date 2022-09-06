package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    //사용해야 하는 operator 선언
    String[] operators = {"+", "*", "-"};
    //dfs 할때 사용할 isVisited 선언
    boolean[] isVisited;
    //operator를 dfs 통해서 순열로 나타낼 List 선언 , [3 * 2 * 1 => 총 6개]
    List<String> combinedOperators;
    public long solution(String expression) {
        //마지막에 최종 값을 저장하고 있을 answer 선언
        long answer = 0;
        //combinedOperators를 ArrayList 로 초기화
        combinedOperators = new ArrayList<>();
        //isVisited 초기화
        isVisited = new boolean[3];

        //operator 를 순열로 나타내줄 dfs 메서드 실행
        dfs("");

        //expression 를 List로 split 해서 가지고 있을 expressionList 선언
        //expression 을 List로 분할해줄 splitExpression 메서드 실행
        List<String> expressionList =  splitExpression(expression);

        //순열로 만들어진 combinedOperators 를 돌면서 최고의 값을 찾아야한다.
        for (String combinedOperator : combinedOperators) {
            //while문 안에서 for문에 사용될 InputList 선언 , 수식이 담긴 expressionList의 주소를 전달
            List<String> inputList = expressionList;
            //계산할때 사용될 stack을 선언
            Stack<String> stack = new Stack<>();
            //combinedOperator의 우선순위를 기억하고 있을 operatorIndex를 선언
            int operatorIndex = 0;

            //while을 돌면서 수식이 1개의 숫자가 남을때까지 반복
            while(true){
                //InputList 만큼 for문을 돌면서 operator의 우선순위에 맞춰서 계산을 진행
                for (int i = 0; i < inputList.size(); i++) {
                    //현재 가져온 Str을 선언
                    String curStr = inputList.get(i);

                    //stack이 비어있지 않고 , stack의 맨 위가 우선순위에 맞는 operator 일 경우 계산을 수행함
                    if (!stack.isEmpty() && isOperator(stack.peek()) && stack.peek().equals(combinedOperator.substring(operatorIndex, operatorIndex + 1))) {
                        //stack을 pop 해서 operator를 꺼낸다.
                        String operator = stack.pop();
                        //한번 더 stack을 pop 해서 계산할때 사용될 값도 꺼낸다.
                        String calculateValue = stack.pop();
                        //operator에 맞게 switch 문을 수행하여 수식을 계산하고 계산한 값을 stack에 넣는다.
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
                        //위에서 말한 조건에 맞지 않는 경우 무조건 stack에 넣는다.
                        stack.push(curStr);
                    }
                }

                //for문을 다 돌고 났을때 stack의 요소 (즉, 계산된 값이 1개만 남아있다면 더 이상 계산할 필요가 없다.)
                //stack에 1개 남은 값을 기존의 answer 와 비교하여 answer를 업데이트 하고 while 루프를 빠져나온다.
                if(stack.size() == 1){
                    answer = Math.max(answer, Math.abs(Long.parseLong(stack.pop())));
                    break;
                }
                //for문이 끝나면 stack에 있는 값 (operator 우선순위에 맞게 계산이 완료된 값)을 다시 inputList 로 넣어준다.
                inputList = new ArrayList<>(stack);
                //stack은 다시 처음부터 사용을 해야하므로 clear 를 한다.
                stack.clear();
                //operator 우선순위를 다음 순위로 넘겨줘야하므로 operatorIndex 를 + 1 해준다.
                operatorIndex ++;
            }
        }

        //combinedOperators 의 모든 요소에 관해서 answer를 구했을때 최고로 큰 값이 answer에 남아있게 되고 해당 값을 return한다.
        return answer;
    }

    //expression 을 List로 분할해줄 메서드
    private List<String> splitExpression(String expression) {
        //반환시에 사용할 result를 ArrayList 로 선언
        List<String> result = new ArrayList<>();
        //분할시에 참고할 Index 변수 선언
        int preIndex = 0;
        //for문을 돌면서 operator를 확인하고 분할 후 result에 추가
        for (int i = 0; i < expression.length(); i++) {
            if(isOperator(expression.charAt(i))){
                //현재 해당하는 글자가 operator 이면
                    //operator 이전까지의 글자를 모아서 result 에 추기
                result.add(expression.substring(preIndex, i));
                    //현재 operator 도 result에 추가
                result.add(expression.substring(i, i + 1)); // operator
                    //현재 operator 도 추가가 됐으므로 preIndex 를 + 1 을 시켜서
                    //다음번에 substring 할때는 operator를 제외한 글자부터 result에 추가
                preIndex = i + 1;
            }
        }
        //for문을 다 돌았으므로 마지막에 남은 문자를 result에 추가
        result.add(expression.substring(preIndex, expression.length()));

        return result;
    }

    //해당 char 가 operator가 맞는지 확인해줄 메서드
    private boolean isOperator(char c) {
        return c == '-' || c == '+' || c == '*';
    }
    //해당 String 이 operator가 맞는지 확인해줄 메서드
    private boolean isOperator(String  str) {
        return str.equals("-") || str.equals("+") || str.equals("*");
    }

    private void dfs(String str) {
        //operator 종류 만큼 순열을 수행하고 메서드를 종료
        if(str.length() == operators.length){
            combinedOperators.add(str);
        }
        else {
            //for문을 돌면서 순열을 실행
            for (int i = 0; i < isVisited.length ; i++) {
                if(!isVisited[i]){
                    isVisited[i] = true;
                    //재귀를 탈때마다 필요한 operator 를 1개씩 추가
                    dfs(str + operators[i]);
                    isVisited[i] = false;
                }
            }
        }
    }
}
