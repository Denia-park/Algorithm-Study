package CodingTest.Programmers;

/*
아이디어
- MST

시간복잡도
- n*logN

자료 구조
- Heao -> priorityHeap (거리가 짧은 순)
 */

import java.util.*;

class Solution {
    public int solution(final int n, final int[][] costs) {
        int answer = 0;

        //graph 만들기
        final Map<Integer, List<Island>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (final int[] cost : costs) {
            final int start = cost[0];
            final int end = cost[1];
            final int costVal = cost[2];

            graph.get(start).add(new Island(end, costVal));
            graph.get(end).add(new Island(start, costVal));
        }

        final boolean[] isVisited = new boolean[n];

        //우선순위 큐 만들기
        final PriorityQueue<Island> pq = new PriorityQueue<>(Comparator.comparingInt(Island::getCost));
        pq.add(new Island(0, 0));

        while (!pq.isEmpty()) {
            final Island current = pq.poll();
            final int curNum = current.num;

            if (isVisited[curNum]) {
                continue;
            }

            final int cost = current.cost;
            answer += cost;

            isVisited[curNum] = true;

            final List<Island> nextList = graph.get(curNum);
            for (final Island island : nextList) {
                if (isVisited[island.num]) {
                    continue;
                }

                pq.add(new Island(island.num, island.cost));
            }
        }

        return answer;
    }

    class Island {
        int num;
        int cost;

        Island(final int num, final int cost) {
            this.num = num;
            this.cost = cost;
        }

        int getCost() {
            return this.cost;
        }
    }
}
