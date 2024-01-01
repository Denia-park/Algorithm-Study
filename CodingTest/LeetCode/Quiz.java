package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}

class Solution {
    public int findContentChildren(final int[] g, final int[] s) {
        int answer = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx = 0;
        int sIdx = 0;

        while (gIdx < g.length && sIdx < s.length) {
            final int greed = g[gIdx];
            final int size = s[sIdx];

            if (greed <= size) {
                answer++;
                gIdx++;
            }

            sIdx++;
        }

        return answer;
    }
}
