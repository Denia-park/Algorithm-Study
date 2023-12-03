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
        final int length = points.length;

        for (int idx = 0; idx < length - 1; idx++) {
            final int[] current = points[idx];
            final int[] next = points[idx + 1];

            answer += Math.max(Math.abs(next[0] - current[0]), Math.abs(next[1] - current[1]));
        }

        return answer;
    }
}
