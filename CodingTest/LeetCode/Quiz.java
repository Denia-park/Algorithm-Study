package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.firstPalindrome(
                new String[]{"abc", "car", "ada", "racecar", "cool"}
        ));
        System.out.println(solution.firstPalindrome(
                new String[]{"notapalindrome", "racecar"}
        ));
        System.out.println(solution.firstPalindrome(
                new String[]{"def", "ghi"}
        ));
    }
}

class Solution {
    public String firstPalindrome(final String[] words) {
        for (final String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private boolean isPalindrome(final String word) {
        final int len = word.length();

        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
