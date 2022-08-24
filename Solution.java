package com.company;

import java.util.Stack;

/*
// 2020 KAKAO BLIND RECRUITMENT
// 괄호 변환
- p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
- 문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
- 만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
*/

class Solution {
    public String solution(String p) {
        // 만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
        if(isPerfectBracket(p))
            return p;

        // "균형잡힌 괄호 문자열" p가 매개변수로 주어질 때,
        // 주어진 알고리즘을 수행해 "올바른 괄호 문자열"로 변환한 결과를 return
        return makeRightBracket(p);
    }

    private String  makeRightBracket(String str) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(str.equals("")) return "";

        // u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 한다.
        // 시작 괄호를 1 , 닫는 괄호를 -1 로 지정해서 합이 0 이면 균형잡힌 괄호 문자열
        // for 문을 돌면서 균형잡힌 괄호 문자열 인지 확인
            // for문을 돌기전에 맨 첫번째 글자를 미리 넣어서 2번째에 바로 균형잡힌 괄호 문자열이 나올 경우를 체크한다.
        int bracketSum = checkBracketSum(str.charAt(0));

        int index;
        for (index = 1; index < str.length(); index++) {
            bracketSum += checkBracketSum(str.charAt(index));

            if(bracketSum == 0){
                index++;
                break;
            }
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = str.substring(0, index);
        String v = str.substring(index);

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(isPerfectBracket(u)){
            return u + makeRightBracket(v);
        }
        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else{
            String tempStr;

            //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            //   4-3. ')'를 다시 붙입니다.
            tempStr = "(" + makeRightBracket(v) + ")";

            //   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            //   4-5. 생성된 문자열을 반환합니다.
            return tempStr + changeUString(u);
        }
    }


    // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    private String changeUString(String u) {
        String rtStr = "";
        // u의 첫 번째와 마지막 문자를 제거
        String tempStr = u.substring(1, u.length() - 1);

        // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        for (int i = 0; i < tempStr.length(); i++) {
            char c = tempStr.charAt(i);

            if (c == '(') {
                rtStr = rtStr + ")";
            }else{
                rtStr = rtStr + "(";
            }
        }

        return rtStr;
    }

    // 시작 괄호를 1 , 닫는 괄호를 -1 로 지정해서 합이 0 이면 균형잡힌 괄호 문자열
    private int checkBracketSum(char strChar) {
        return strChar == '(' ? 1 : -1;
    }

    //올바른 괄호 문자열인지 확인하는 메서드
    private boolean isPerfectBracket(String str) {
        Stack<Character> stack = new Stack<>();

        //str 길이 만큼 for 문을 돌면서 스택을 이용하여 올바른 괄호 문자열인지 체크
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
