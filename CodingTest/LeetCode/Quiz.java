package CodingTest.LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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
        int count = 0;

        final PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] arr) -> arr[1])
        );

        Collections.addAll(pq, points);

        while (!pq.isEmpty()) {
            final int[] cur = pq.poll();

            //현재의 끝나는 부분이 다음의 시작보다 크면 서로 겹치므로 해당 풍선은 제거한다.
            while (!pq.isEmpty() && cur[1] >= pq.peek()[0]) {
                pq.poll();
            }

            count++;
        }

        return count;
    }
}
