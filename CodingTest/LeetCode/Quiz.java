package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution {
    private List<String> result;
    private int maxBracketsNum;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        this.maxBracketsNum = n;

        addParenthesis("", 0, 0);

        return result;
    }

    private void addParenthesis(final String curStr, final int openBrackets, final int closeBrackets) {
        //괄호는 () 이렇게 생김 -> 문자열이 2배. 즉 maxBracketsNum 2개면 괄호 쌍이 2개 이므로 문자열 길이가 2*2 = 4 이다.
        if (curStr.length() == maxBracketsNum * 2) {
            result.add(curStr);
            return;
        }

        if (openBrackets < maxBracketsNum) {
            addParenthesis(curStr + "(", openBrackets + 1, closeBrackets);
        }
        if (closeBrackets < openBrackets) {
            addParenthesis(curStr + ")", openBrackets, closeBrackets + 1);
        }
    }
}
