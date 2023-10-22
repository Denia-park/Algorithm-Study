package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLastWord("Hello World") == 5);
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  ") == 4);
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy") == 6);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        final String trimmed = s.trim();

        final int firstCharIndex = trimmed.lastIndexOf(" ") + 1;

        final int trimLength = trimmed.length();

        return trimLength - firstCharIndex;
    }
}
