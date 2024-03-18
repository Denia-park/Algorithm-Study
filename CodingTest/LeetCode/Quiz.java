package CodingTest.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findMinArrowShots(
                new int[][]{
                        new int[]{10, 16},
                        new int[]{2, 8},
                        new int[]{1, 6},
                        new int[]{7, 12}
                }
        ));
        System.out.println(solution.findMinArrowShots(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6},
                        new int[]{7, 8}
                }
        ));
        System.out.println(solution.findMinArrowShots(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{4, 5}
                }
        ));
    }
}

class Solution {
    public int findMinArrowShots(final int[][] points) {
        int count = 1;

        Arrays.sort(points, Comparator.comparingInt((int[] arr) -> arr[1]));

        final int length = points.length;
        int idx = 1;
        int end = points[0][1];
        for (; idx < length; idx++) {
            final int[] curPoint = points[idx];
            if (end < curPoint[0]) {
                count++;
                end = curPoint[1];
            }
        }

        return count;
    }
}
