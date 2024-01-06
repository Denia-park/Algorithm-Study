package CodingTest.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }
}

class Solution {
    public int jobScheduling(final int[] startTime, final int[] endTime, final int[] profit) {
        final int numJobs = profit.length; // Number of jobs
        final Job[] jobs = initJobs(startTime, endTime, profit);

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        final int[] dp = new int[numJobs + 1];

        for (int curCount = 1; curCount <= numJobs; curCount++) {
            final int jobIdx = curCount - 1;

            final int curStartTime = jobs[jobIdx].startTime;
            final int curProfit = jobs[jobIdx].profit;

            final int latestNonConflictJobIndex = upperBound(jobs, jobIdx, curStartTime);
            
            dp[curCount] = Math.max(dp[curCount - 1], dp[latestNonConflictJobIndex] + curProfit);
        }

        return dp[numJobs];
    }

    private Job[] initJobs(final int[] startTime, final int[] endTime, final int[] profit) {
        final int numJobs = profit.length; // Number of jobs
        final Job[] jobs = new Job[numJobs];

        for (int i = 0; i < numJobs; ++i) {
            jobs[i] = new Job(endTime[i], startTime[i], profit[i]);
        }

        return jobs;
    }

    private int upperBound(final Job[] jobs, final int endIndex, final int targetTime) {
        int low = 0;
        int high = endIndex;

        while (low < high) {
            final int mid = (low + high) / 2;
            if (jobs[mid].endTime <= targetTime) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static class Job {
        int endTime;
        int startTime;
        int profit;

        public Job(final int endTime, final int startTime, final int profit) {
            this.endTime = endTime;
            this.startTime = startTime;
            this.profit = profit;
        }
    }
}
