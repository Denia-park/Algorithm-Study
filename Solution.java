// 백준 - 3613 - Java vs C++

import java.util.Stack;

class Solution {
    public String solution(String quizString) {
        boolean errFlag = false;
        boolean changeFlag = false;

        Stack<Character> stack = new Stack<>();

        char startCh = quizString.charAt(0);

        if (startCh == '_' || Character.isUpperCase(startCh) ||
                quizString.charAt(quizString.length() - 1) == '_') {
            return "Error!";
        }

        for (int i = 0; i < quizString.length(); i++) {
            char ch = quizString.charAt(i);

            if (ch == '_') {
                errFlag = true;
            } else {
                if (errFlag && Character.isUpperCase(ch)) {
                    return "Error!";
                }
            }

            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char topChar = stack.peek();

            if (changeFlag) {
                stack.push(ch);
                changeFlag = false;
                continue;
            }

            if (topChar == '_') {
                if (ch == '_') {
                    return "Error!";
                }
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

        StringBuilder sb = new StringBuilder();

        for (Character tempCh : stack) {
            sb.append(tempCh);
        }
        return sb.toString();
    }
}
