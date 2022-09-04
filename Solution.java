package com.company;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();
        //왼쪽으로 회전시키는 것이기 때문에 문자열의 길이만큼 기존 문자열의 오른쪽에 붙여주면 된다.
        String editStr = s + s.substring(0, sLength - 1);
        //for문을 돌면서 몇칸을 돌렸는지 계산이 가능하다.
        for (int i = 0; i < sLength; i++) {
            String editTempStr = editStr.substring(i, i + sLength);
            if(isRightBracket(editTempStr))
                answer++;
        }
        return answer;
    }

    // 옳은 괄호쌍인지 확인하는 메서드
    private boolean isRightBracket(String editTempStr) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < editTempStr.length(); i++) {
            char tempChar = editTempStr.charAt(i);
            //비어있지 않거나 닫는 괄호가 나오면 stack 을 peek 해서 어떤 괄호가 있는지 확인 해야함
            //닫는 괄호와 맞지 않는 괄호가 나올 경우 잘못된 괄호쌍 이므로 return false
            if(!stack.isEmpty() && isClosedBracket(tempChar)){
                char tempStackPeek = stack.peek();
                if(tempChar == '}' && tempStackPeek == '{'){
                    stack.pop();
                }else if(tempChar == ']' && tempStackPeek == '['){
                    stack.pop();
                }else if(tempChar == ')' && tempStackPeek == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }else{
                //stack이 비어있거나 여는 괄호면 무조건 push
                stack.push(tempChar);
            }
        }
        //for문이 끝났는데 남아있으면 잘못된 괄호쌍
        return stack.isEmpty();
    }

    //닫힌 괄호인지 확인하는 메서드
    private boolean isClosedBracket(char tempChar) {
        return tempChar == '}' || tempChar == ']' || tempChar == ')';
    }
}
