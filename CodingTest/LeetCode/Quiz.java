package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(solution.maxLengthBetweenEqualCharacters("abcbxaasadqwc"));
    }
}

class Solution {
    public int maxLengthBetweenEqualCharacters(final String s) {
        int answer = -1;

        final int[] position = new int[26];
        Arrays.fill(position, -1);

        for (int idx = 0; idx < s.length(); idx++) {
            final int chIdx = s.charAt(idx) - 'a';
            final int prePosition = position[chIdx];

            if (prePosition != -1) {
                answer = Math.max(answer, idx - prePosition - 1);
            }

            //idx 저장
            if (prePosition == -1) {
                position[chIdx] = idx;
            }
        }

        return answer;
    }
}
