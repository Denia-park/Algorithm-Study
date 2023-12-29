package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(solution.minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(solution.minDifficulty(new int[]{1, 1, 1}, 3));
        System.out.println(solution.minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }
}

class Solution {
    public int minDifficulty(final int[] jobDifficulty, final int dayLimit) {
        final int jobsLength = jobDifficulty.length;

        if (jobsLength < dayLimit) return -1;
        if (jobsLength == dayLimit) return Arrays.stream(jobDifficulty).sum();

        // Initialize a 2D array to store difficulty for each day and job
        final int[][] dp = new int[dayLimit + 1][jobsLength + 1];

        // Fill the first day's difficulties
        dp[1][1] = jobDifficulty[0];
        for (int jobCountIdx = 2; jobCountIdx <= jobsLength; jobCountIdx++) {
            dp[1][jobCountIdx] = Math.max(dp[1][jobCountIdx - 1], jobDifficulty[jobCountIdx - 1]);
        }

        // Iterate over each day (start from 2nd day)
        for (int dayCount = 2; dayCount <= dayLimit; dayCount++) {
            //Iterate over each job (start from (day * 1) because we need at least 1 job per day)
            for (int jobDoneCount = dayCount; jobDoneCount <= jobsLength; jobDoneCount++) {
                int localMax = jobDifficulty[jobDoneCount - 1];
                dp[dayCount][jobDoneCount] = Integer.MAX_VALUE; // Set an initial high value

                // Iterate over previous jobs to find optimal difficulty
                for (int prevJobDoneCount = jobDoneCount; prevJobDoneCount >= dayCount; prevJobDoneCount--) {
                    localMax = Math.max(localMax, jobDifficulty[prevJobDoneCount - 1]);
                    dp[dayCount][jobDoneCount] = Math.min(dp[dayCount][jobDoneCount], dp[dayCount - 1][prevJobDoneCount - 1] + localMax);
                }
            }
        }

        return dp[dayLimit][jobsLength];
    }
}
