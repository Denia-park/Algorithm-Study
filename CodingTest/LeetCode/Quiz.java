package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.customSortString("cba", "abcd"));
        System.out.println(solution.customSortString("bcafg", "abcd"));
    }
}

class Solution {
    public String customSortString(final String order, final String s) {
        final Map<String, Integer> sortMap = new HashMap<>();

        final char[] charArray = order.toCharArray();
        final int length = charArray.length;
        for (int i = 0; i < length; i++) {
            sortMap.put(String.valueOf(charArray[i]), i);
        }

        final List<String> answer = new ArrayList<>();
        final char[] quiz = s.toCharArray();
        for (final char c : quiz) {
            answer.add(String.valueOf(c));
        }

        answer.sort(Comparator.comparingInt(ch -> sortMap.getOrDefault(ch, 100)));

        String rtStr = "";
        for (final String str : answer) {
            rtStr += str;
        }

        return rtStr;
    }
}
