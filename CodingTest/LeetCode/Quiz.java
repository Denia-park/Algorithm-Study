package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(
//                solution.furthestBuilding(
//                        new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1
//                )
//        );
        System.out.println(
                solution.furthestBuilding(
                        new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2
                )
        );
//        System.out.println(
//                solution.furthestBuilding(
//                        new int[]{14, 3, 19, 3}, 17, 0
//                )
//        );
    }
}

class Solution {
    public int furthestBuilding(final int[] heights, int bricks, int ladders) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx;
        for (idx = 0; idx < heights.length - 1; idx++) {
            final int height = heights[idx];
            final int nextHeight = heights[idx + 1];

            if (height >= nextHeight) {
                continue;
            }

            final int diff = nextHeight - height;

            bricks -= diff;
            //우선순위 큐에 사용한 벽돌 수를 저장
            pq.offer(diff);

            if (bricks >= 0) {
                continue;
            }

            //벽돌도 모자르고, 사다리로 모자르면 끝
            if (ladders <= 0) {
                break;
            }

            //벽돌이 모자를 때, 최고로 벽돌을 많이 쓴 타이밍에 대신 사다리를 사용
            //사다리가 남아 있으면 -> 사다리를 하나 차감하고, 많이 쓴 벽돌을 원상복구 시키면서 현재 쓰는 벽돌 차감
            ladders -= 1;
            bricks += pq.poll();
        }

        return idx;
    }
}
