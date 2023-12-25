package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numDecodings("12") == 2);
        System.out.println(solution.numDecodings("226") == 3);
        System.out.println(solution.numDecodings("06") == 0);
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
    }
}

class Solution {
    private Map<String, Character> mappingCode;
    private Set<String> answerSet;

    public int numDecodings(final String s) {
        mappingCode = new HashMap<>();
        answerSet = new HashSet<>();
        mappingCode();

        // dfs를 사용하자.
        dfs(s, "");

        for (final String answer : answerSet) {
            System.out.println("answer = " + answer);
        }
        System.out.println("answerSet Size() = " + answerSet.size());
        return answerSet.size();
    }

    private void dfs(final String restString, final String answerString) {
        if (restString.isEmpty()) {
            answerSet.add(answerString);
            return;
        }

        // 1. 1개의 문자를 사용하는 경우
        // 2. 2개의 문자를 사용하는 경우
        for (int idx = 1; idx <= 2; idx++) {
            if (restString.length() < idx) {
                continue;
            }

            final String code = restString.substring(0, idx);
            final String rest = restString.substring(idx);

            if (!mappingCode.containsKey(code)) {
                continue;
            }

            dfs(rest, answerString + mappingCode.get(code));
        }
    }

    private void mappingCode() {
        for (int i = 0; i < 26; i++) {
            mappingCode.put(String.valueOf(i + 1), (char) ('A' + i));
        }
    }
}
