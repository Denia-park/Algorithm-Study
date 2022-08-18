package com.company;

import java.util.Stack;

class Solution {
    boolean solution(String problem) {
        boolean answer = true;

        //스택을 생성
        Stack<Character> st = new Stack<Character>();

        //값을 집어넣을때마다 비교한다.
        for (int i = 0; i < problem.length(); i++) {
            char tempChar = problem.charAt(i);
            if (tempChar == '(') {
                st.push(tempChar);
            } else {
                // 닫는 괄호가 있는데
                    // stack이 비어있으면 false
                    // 여는 괄호가 없으면 false
                if (st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }
        }

        //마지막에 스택에 내용이 남아있어도 false
        if(!st.isEmpty())
            return false;

        return answer;
    }
}
