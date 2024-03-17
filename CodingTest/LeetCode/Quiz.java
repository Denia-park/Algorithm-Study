package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((Arrays.deepToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}))));
        System.out.println((Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}))));
    }
}

class Solution {
    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        final int n = intervals.length;
        int i = 0;
        final List<int[]> res = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return res.toArray(new int[res.size()][]);
    }
}
