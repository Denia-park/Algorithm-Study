package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.customSortString("cba", "abcd"));
        System.out.println(solution.customSortString("bcafg", "abcd"));
    }
}

class Solution {
    public String customSortString(final String order, final String s) {
        final int[] chars = new int[26];
        Arrays.fill(chars, 100);

        final char[] charArray = order.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            final int ch = charArray[i] - 'a';

            chars[ch] = i;
        }

        final List<Character> answer = new ArrayList<>();
        final char[] quiz = s.toCharArray();
        for (final char c : quiz) {
            answer.add(c);
        }

        final List<Character> collect = answer.stream()
                .sorted(Comparator.comparingInt(ch -> chars[ch - 'a']))
                .collect(Collectors.toList());

        final StringBuilder sb = new StringBuilder();
        for (final Character ch : collect) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
