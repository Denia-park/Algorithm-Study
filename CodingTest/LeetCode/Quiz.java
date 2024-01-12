package CodingTest.LeetCode;

import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.halvesAreAlike("book"));
        System.out.println("2 : " + solution.halvesAreAlike("textbook"));
    }
}

class Solution {
    List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    public boolean halvesAreAlike(final String s) {
        final String lowerCase = s.toLowerCase();

        final int length = lowerCase.length();

        int leftCount = 0;

        for (int i = 0; i < (length / 2); i++) {
            if (vowels.contains(lowerCase.charAt(i))) {
                leftCount++;
            }
        }

        int rightCount = 0;

        for (int i = (length / 2); i < length; i++) {
            if (vowels.contains(lowerCase.charAt(i))) {
                rightCount++;
            }
        }

        return leftCount == rightCount;
    }
}
