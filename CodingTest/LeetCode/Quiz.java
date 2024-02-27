package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.commonChars(
                new String[]{"bella", "label", "roller"}
        ));
        System.out.println(solution.commonChars(
                new String[]{"cool", "lock", "cook"}
        ));
    }
}

class Solution {
    public List<String> commonChars(final String[] words) {
        final int[] chars = new int[26];

        final int len = words.length;
        for (final String word : words) {
            final char[] temp = word.toCharArray();

            for (final char c : temp) {
                chars[c - 'a']++;
            }
        }

        final List<String> answer = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            final int val = chars[i];

            final int div = val / len;
            if (div > 0 && val % len == 0) {
                for (int j = 0; j < div; j++) {
                    final char c = (char) ('a' + i);
                    answer.add(String.valueOf(c));
                }
            }
        }

        return answer;
    }
}
