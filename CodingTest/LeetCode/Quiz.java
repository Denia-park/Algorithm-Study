package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.fill(chars, Integer.MAX_VALUE);
        
        for (final String word : words) {
            final char[] temp = word.toCharArray();

            final int[] tempChars = new int[26];
            for (final char c : temp) {
                tempChars[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                chars[i] = Math.min(chars[i], tempChars[i]);
            }
        }

        final List<String> answer = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            final int val = chars[i];

            for (int j = 0; j < val; j++) {
                answer.add(String.valueOf((char) ('a' + i)));
            }
        }

        return answer;
    }
}
