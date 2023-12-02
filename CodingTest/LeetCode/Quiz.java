package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}

class Solution {
    public int countCharacters(final String[] words, final String chars) {
        final int[] charsCount = new int[26];
        extractCharArray(charsCount, chars);

        int answer = 0;

        for (final String tempWord : words) {
            final int[] charsCountCopy = Arrays.copyOf(charsCount, charsCount.length);
            final int length = tempWord.length();
            boolean isEnable = true;

            for (int j = 0; j < length; j++) {
                final int charValue = tempWord.charAt(j) - 'a';

                if (0 < charsCountCopy[charValue]) {
                    charsCountCopy[charValue]--;
                } else {
                    isEnable = false;
                    break;
                }
            }

            if (isEnable) {
                answer += length;
            }
        }

        return answer;
    }

    private void extractCharArray(final int[] charsArray, final String string) {
        for (int i = 0; i < string.length(); i++) {
            charsArray[string.charAt(i) - 'a']++;
        }
    }
}
