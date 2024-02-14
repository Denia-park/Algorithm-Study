package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.rearrangeArray(
                new int[]{3, 1, -2, -5, 2, -4}
        )));
        System.out.println(Arrays.toString(solution.rearrangeArray(
                new int[]{1, -1}
        )));
    }
}

class Solution {
    public int[] rearrangeArray(final int[] nums) {
        final int length = nums.length;
        final int[] answer = new int[length];

        int posIdx = 0;
        int negIdx = 1;

        for (final int val : nums) {
            if (val > 0) {
                answer[posIdx] = val;
                posIdx += 2;
            } else {
                answer[negIdx] = val;
                negIdx += 2;
            }
        }

        return answer;
    }
}
