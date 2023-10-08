package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code") == 2);
        System.out.println(solution.rearrangeCharacters("abcba", "abc") == 1);
        System.out.println(solution.rearrangeCharacters("abbaccaddaeea", "aaaaa") == 1);
    }
}

class Solution {
    public int rearrangeCharacters(final String s, final String t) {
        int answer = Integer.MAX_VALUE;

        final int[] sArr = new int[26];
        final int[] tArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            tArr[t.charAt(i) - 'a'] += 1;
        }

        for (final char c : t.toCharArray()) {
            final int key = c - 'a';
            if (sArr[key] == 0) {
                return 0;
            } else {
                answer = Math.min(answer, sArr[key] / tArr[key]);
            }
        }

        return answer;
    }
}
