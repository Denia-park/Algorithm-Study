package CodingTest.Programmers;

import java.util.*;

class Solution {
    private boolean[] isVisited;
    private Map<Integer, Set<Integer>> result;
    private int maxDistance = -1;

    public int solution(final int n, final int[][] edge) {
        isVisited = new boolean[n + 1];
        result = new TreeMap<>();

        final List<List<Integer>> graph = new ArrayList<>();

        //그래프 구성 완성
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (final int[] ints : edge) {
            final int from = ints[0];
            final int to = ints[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //bfs로 계산해서 가장 먼 노드의 수를 구하자.
        bfs(graph);

        return result.get(maxDistance).size();
    }

    private void bfs(final List<List<Integer>> graph) {
        final Deque<Node> dq = new ArrayDeque<>();
        isVisited[1] = true;
        dq.add(new Node(1, 0));

        while (!dq.isEmpty()) {
            final Node node = dq.pollFirst();

            final int value = node.value;
            final int distance = node.distance;

            maxDistance = Math.max(maxDistance, distance);

            final Set<Integer> saveDistanceSet = result.getOrDefault(distance, new HashSet<>());
            saveDistanceSet.add(value);
            result.put(distance, saveDistanceSet);

            for (final Integer nextValue : graph.get(value)) {
                if (isVisited[nextValue]) {
                    continue;
                }

                isVisited[nextValue] = true;
                final Node nextNode = new Node(nextValue, distance + 1);
                dq.add(nextNode);
            }
        }
    }

    class Node {
        int value;
        int distance;

        public Node(final int value, final int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}
