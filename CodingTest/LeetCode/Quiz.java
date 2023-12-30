package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.makeEqual(new String[]{"abc", "aabc", "bc"}));
    }
}

class Solution {
    public boolean makeEqual(final String[] words) {
        final int totalWord = words.length;

        final int[] alphabet = new int[26];

        for (final String word : words) {
            for (final char ch : word.toCharArray()) {
                alphabet[ch - 'a']++;
            }
        }

        for (final int value : alphabet) {
            if (value % totalWord != 0) {
                return false;
            }
        }

        return true;
    }
}
