package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.firstUniqChar("leetcode")));
        System.out.println((solution.firstUniqChar("loveleetcode")));
        System.out.println((solution.firstUniqChar("aabb")));
    }
}

class Solution {
    public int firstUniqChar(final String s) {
        final char[] chars = s.toCharArray();
        final int[] arr = new int[26];

        for (final char ch : chars) {
            arr[ch - 'a']++;
        }

        final int charsLen = chars.length;
        for (int i = 0; i < charsLen; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
