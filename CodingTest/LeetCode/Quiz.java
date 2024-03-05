package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minimumLength("ca"));
        System.out.println(solution.minimumLength("cabaabac"));
        System.out.println(solution.minimumLength("aabccabba"));
        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}

class Solution {
    public int minimumLength(final String s) {
        final char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                break;
            }

            final char ch = chars[start];

            while (start <= end && chars[start] == ch) {
                start++;
            }

            while (start < end && chars[end] == ch) {
                end--;
            }
        }

        return end - start + 1;
    }
}
