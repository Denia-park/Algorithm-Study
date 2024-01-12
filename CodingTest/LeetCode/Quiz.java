package CodingTest.LeetCode;

import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.halvesAreAlike("book"));
        System.out.println("2 : " + solution.halvesAreAlike("textbook"));
    }
}

class Solution {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(final String s) {
        final char[] chars = s.toCharArray();
        final int length = s.length();

        return countVowel(chars, 0, (length / 2))
                == countVowel(chars, (length / 2), length);
    }

    private int countVowel(final char[] chars, final int start, final int end) {
        int count = 0;

        for (int i = start; i < end; i++) {
            if (vowels.contains(chars[i])) {
                count++;
            }
        }

        return count;
    }
}
