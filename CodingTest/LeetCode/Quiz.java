package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.minWindow("ADOBECODEBANC", "ABC")));
        System.out.println((solution.minWindow("a", "a")));
        System.out.println((solution.minWindow("a", "aa")));
        System.out.println((solution.minWindow("ab", "a")));
    }
}

class Solution {
    private static final int INF = (int) Math.pow(10, 8);

    public String minWindow(final String str, final String target) {
        final int strLen = str.length();
        final Map<Character, Integer> strMap = new HashMap<>();
        final Map<Character, Integer> targetMap = new HashMap<>();

        for (final char ch : target.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int st = 0;
        int ed = 0;

        char edChar = str.charAt(ed);
        strMap.put(edChar, strMap.getOrDefault(edChar, 0) + 1);

        int answerLen = INF;
        String answerStr = "";

        while (st < str.length()) {
            final int curLen = ed - st + 1;
            if (isRight(strMap, targetMap) && curLen < answerLen) {
                answerLen = curLen;
                answerStr = str.substring(st, ed + 1);

                //빼기
                final char stChar = str.charAt(st);
                strMap.put(stChar, strMap.get(stChar) - 1);
                st++;
                continue;
            }

            if (ed == (strLen - 1)) {
                //빼기
                final char stChar = str.charAt(st);
                strMap.put(stChar, strMap.get(stChar) - 1);
                st++;
            } else {
                ed++;
                edChar = str.charAt(ed);
                strMap.put(edChar, strMap.getOrDefault(edChar, 0) + 1);
            }
        }

        return answerStr;
    }

    boolean isRight(final Map<Character, Integer> origin, final Map<Character, Integer> target) {
        for (final Character ch : target.keySet()) {
            final Integer originVal = origin.getOrDefault(ch, 0);
            final Integer targetVal = target.getOrDefault(ch, 0);

            if (originVal < targetVal) {
                return false;
            }
        }

        return true;
    }
}
