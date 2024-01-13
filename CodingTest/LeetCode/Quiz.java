package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.minSteps("bab", "aba"));
        System.out.println("2 : " + solution.minSteps("leetcode", "practice"));
        System.out.println("3 : " + solution.minSteps("anagram", "mangaar"));
    }
}

class Solution {
    public int minSteps(final String s, final String t) {
        final char[] sCharArr = s.toCharArray();
        final char[] tCharArr = t.toCharArray();
        final int[] sArr = new int[26];
        final int[] tArr = new int[26];
        final int length = s.length();

        for (int i = 0; i < length; i++) {
            sArr[sCharArr[i] - 'a']++;
            tArr[tCharArr[i] - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            if (sArr[i] > tArr[i]) {
                result += (sArr[i] - tArr[i]);
            }
        }

        return result;
    }
}
