package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.furthestBuilding(
                        new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1
                )
        );
        System.out.println(
                solution.furthestBuilding(
                        new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2
                )
        );
        System.out.println(
                solution.furthestBuilding(
                        new int[]{14, 3, 19, 3}, 17, 0
                )
        );
    }
}

class Solution {
    public int furthestBuilding(final int[] h, int b, int l) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx;
        for (idx = 0; idx < h.length - 1; idx++) {
            final int diff = h[idx + 1] - h[idx];

            if (diff <= 0) {
                continue;
            }

            b -= diff;
            //우선순위 큐에 사용한 벽돌 수를 저장
            pq.offer(diff);

            if (b < 0) {
                l--;
                b += pq.poll();
            }

            //벽돌도 모자르고, 사다리로 모자르면 끝
            if (l < 0) {
                break;
            }
        }

        return idx;
    }
}
