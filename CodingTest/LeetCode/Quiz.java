package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }
}

class Solution {
    public int minTimeToVisitAllPoints(final int[][] points) {
        int answer = 0;

        for (int idx = 0; idx < points.length - 1; idx++) {
            final int[] current = points[idx];
            final int[] next = points[idx + 1];

            final int diffX = Math.abs(next[0] - current[0]);
            final int diffY = Math.abs(next[1] - current[1]);

            final int minDiff = Math.min(diffX, diffY);
            final int maxDiff = Math.max(diffX, diffY);

            if (minDiff != 0) {
                final int div = maxDiff / minDiff;
                answer += div;

                final int rest = maxDiff - div;
                answer += rest;
            } else {
                answer += maxDiff;
            }
        }

        return answer;
    }
}
