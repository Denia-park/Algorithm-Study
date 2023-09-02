package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    int totalNode;
    int gDestination;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        totalNode = n;
        gDestination = destination;
        List<List<Integer>> graph = new ArrayList<>();

        //n개 만큼 List 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        List<Integer> answer = new ArrayList<>();
        for (int source : sources) {
            final int val = bfs(source, graph);
            answer.add(val);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int bfs(final int source, final List<List<Integer>> graph) {
        int minValue = Integer.MAX_VALUE;
        Deque<Info> deque = new ArrayDeque<>();

        boolean[] visited = new boolean[totalNode + 1];
        deque.add(new Info(0, source));
        visited[source] = true;

        while (!deque.isEmpty()) {
            Info info = deque.poll();
            if (info.value == gDestination) {
                minValue = Math.min(minValue, info.count);
            }

            for (int next : graph.get(info.value)) {
                if (!visited[next]) {
                    visited[next] = true;
                    deque.add(new Info(info.count + 1, next));
                }
            }
        }

        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    class Info {
        int count;
        int value;

        Info(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }
}
