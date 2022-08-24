package com.company;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(isPerfectBracket(p))
            return p;

        return makeRightBracket(p);
    }

    private String  makeRightBracket(String str) {
        if(str.equals("")) return "";

        int bracketSum = 0;

        bracketSum += checkBracketSum(str.charAt(0));

        int index;
        for (index = 1; index < str.length(); index++) {
            bracketSum += checkBracketSum(str.charAt(index));

            if(bracketSum == 0){
                index++;
                break;
            }
        }

        String u = str.substring(0, index);
        String v = str.substring(index);

        if(isPerfectBracket(u)){
            return u + makeRightBracket(v);
        }else{
            String tempStr;

            tempStr = "(" + makeRightBracket(v) + ")";

            return tempStr + changeUString(u);
        }
    }

    private String changeUString(String u) {
        String rtStr = "";
        String tempStr = u.substring(1, u.length() - 1);

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

    private int checkBracketSum(char strChar) {
        return strChar == '(' ? 1 : -1;
    }

    private boolean isPerfectBracket(String str) {
        Stack<Character> stack = new Stack<>();

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
