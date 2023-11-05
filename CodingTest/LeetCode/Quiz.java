package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return List.of("()");
        }

        Set<String> set = new HashSet<>();

        List<String> list = List.of("()");

        for (int i = 2; i < n + 1; i++) {
            for (String str : list) {
                //str에서 ()를 찾고 교환하자.
                int index = str.indexOf("()");

                while (index != -1) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.replace(index, index + 2, "(())");
                    set.add(sb.toString());

                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.replace(index, index + 2, "()()");
                    set.add(sb2.toString());

                    index = str.indexOf("()", index + 1);
                }
            }

            list = new ArrayList<>(set);
            set.clear();
        }

        //set to list
        return list;
    }
}
