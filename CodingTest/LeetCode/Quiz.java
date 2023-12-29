package CodingTest.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(solution.minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(solution.minDifficulty(new int[]{1, 1, 1}, 3));
    }
}

class Solution {
    public int minDifficulty(final int[] jobDifficulty, final int d) {
        final int len = jobDifficulty.length;

        if (len < d) return -1;

        final List<Integer> jobDiffList = Arrays.stream(jobDifficulty)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        final int maxDiff = jobDiffList.get(0);
        int restDiff = 0;
        for (int i = jobDifficulty.length - 1; i >= len - (d - 1); i--) {
            final int diff = jobDifficulty[i];

            restDiff += diff;
        }

        return maxDiff + restDiff;
    }
}
