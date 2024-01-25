package CodingTest.Programmers;

/*
아이디어
- MST

- MST -> 크루스칼 및 프림 풀이법이 있다
- 크루스칼 - Union + Find 써야함 (O(e * log e))
- 프림 - 우선순위 큐를 이용함 (O(node * node))

- 프림 알고리즘 사용함

시간복잡도
- n*n

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

        for (final int[] costArr : costs) {
            final int from = costArr[0];
            final int to = costArr[1];
            final int cost = costArr[2];

            graph.get(from).add(new Island(to, cost));
            graph.get(to).add(new Island(from, cost));
        }

        final boolean[] isVisited = new boolean[n];

        //우선순위 큐 만들기
        final PriorityQueue<Island> pq = new PriorityQueue<>(Comparator.comparingInt((Island island) -> island.cost));
        pq.add(new Island(0, 0));

        while (!pq.isEmpty()) {
            final Island current = pq.poll();
            final int curNum = current.num;

            if (isVisited[curNum]) continue;

            isVisited[curNum] = true;
            answer += current.cost;

            for (final Island island : graph.get(curNum)) {
                if (isVisited[island.num]) continue;

                pq.add(new Island(island.num, island.cost));
            }
        }

        return answer;
    }

    static class Island {
        int num, cost;

        Island(final int num, final int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
