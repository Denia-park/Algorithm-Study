package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(Arrays.deepToString(solution.divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)));
    }
}

class Solution {
    public int[][] divideArray(final int[] nums, final int k) {
        final List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        final List<Integer> temp = new ArrayList<>();
        for (final int num : nums) {
            if (temp.isEmpty()) {
                temp.add(num);
                continue;
            }

            final Integer minValue = temp.get(0);
            if (num - minValue <= k && temp.size() < 3) {
                temp.add(num);
            } else {
                final List<Integer> move = new ArrayList<>();
                for (final Integer val : temp) {
                    move.add(val);
                }

                answer.add(move);
                temp.clear();

                temp.add(num);
            }
        }

        if (temp.size() % 3 != 0) {
            return new int[0][0];
        }

        answer.add(temp);

        final int[][] answerArr = new int[answer.size()][3];

        int idx = 0;
        for (final List<Integer> integers : answer) {
            final int[] tempArr = new int[3];

            final int size = integers.size();
            if (size % 3 != 0) {
                return new int[0][0];
            }

            for (int i = 0; i < size; i++) {
                final Integer val = integers.get(i);

                tempArr[i] = val;
            }

            answerArr[idx++] = tempArr;
        }

        return answerArr;
    }
}
