package CodingTest.Programmers;

import java.util.*;

class Solution {
    int totalNode;
    int gDestination;
    Map<Integer, Integer> saveMap;
    int[] distances;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        totalNode = n;
        gDestination = destination;
        saveMap = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();

        //n개 만큼 List 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        dijkstra(sources, graph);

        List<Integer> answer = new ArrayList<>();
        for (int source : sources) {
            answer.add(distances[source] == Integer.MAX_VALUE ? -1 : distances[source]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void dijkstra(final int[] sources, final List<List<Integer>> graph) {
        Deque<Info> deque = new ArrayDeque<>();
        deque.addLast(new Info(gDestination, 0));
        distances[gDestination] = 0;

        while (!deque.isEmpty()) {
            final Info info = deque.pollFirst();
            int curValue = info.value;
            int curDistance = info.distance;

            if (distances[curValue] != curDistance) {
                continue;
            }

            for (int next : graph.get(curValue)) {
                if (distances[next] > curDistance + 1) {
                    distances[next] = curDistance + 1;
                    deque.addLast(new Info(next, curDistance + 1));
                }
            }
        }
    }

    class Info {
        int value;
        int distance;

        Info(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}
