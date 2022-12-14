// 백준 - 3613 - Java vs C++

import java.util.Stack;

class Solution {
    public String solution(String quizString) {
        boolean errFlag = false;
        boolean changeFlag = false;

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < quizString.length(); i++) {
            char ch = quizString.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char topChar = stack.peek();

            if (Character.isUpperCase(topChar) && Character.isUpperCase(ch)) {
                errFlag = true;
                break;
            } else if (topChar == '_' && Character.isUpperCase(ch)) {
                errFlag = true;
                break;
            }

            if (changeFlag) {
                stack.push(ch);
                changeFlag = false;
                continue;
            }

            if (topChar == '_') {
                stack.pop();
                stack.push(Character.toUpperCase(ch));
                changeFlag = true;
            } else if (Character.isUpperCase(topChar)) {
                stack.pop();
                stack.push('_');
                stack.push(Character.toLowerCase(topChar));
                stack.push(ch);
                changeFlag = true;
            } else {
                stack.push(ch);
            }
        }

        if (errFlag) {
            return "Error!";
        } else {
            for (Character tempCh : stack) {
                sb.append(tempCh);
            }
            return sb.toString();
        }
    }
}
