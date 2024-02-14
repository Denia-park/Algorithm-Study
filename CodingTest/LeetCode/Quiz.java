package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final List<Integer> posi = new ArrayList<>();
        final List<Integer> nega = new ArrayList<>();

        for (final int i : nums) {
            if (i > 0) {
                posi.add(i);
            } else {
                nega.add(i);
            }
        }

        final int[] answer = new int[nums.length];

        final int len = posi.size();
        for (int i = 0; i < len; i++) {
            answer[i * 2] = posi.get(i);
            answer[i * 2 + 1] = nega.get(i);
        }

        return answer;
    }
}
