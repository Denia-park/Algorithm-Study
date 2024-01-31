package CodingTest.Programmers;

/*
아이디어 - BFS
네트워크 개수 구하기
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(final int n, final int[][] computers) {
        int answer = 0;
        final List<List<Integer>> graph = new ArrayList<>();

        //처음에 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int start = 0; start < computers.length; start++) {
            final int[] computer = computers[start];

            for (int end = start + 1; end < computer.length; end++) {
                if (computer[end] == 1) {
                    graph.get(start).add(end);
                    graph.get(end).add(start);
                }
            }
        }

        final boolean[] isVisited = new boolean[n];

        //네트워크 파악을 위해 0 ~ n-1 까지 순회
        for (int start = 0; start < n; start++) {
            if (isVisited[start]) continue;

            bfs(graph, isVisited, start);
            answer++;
        }

        return answer;
    }

    private void bfs(final List<List<Integer>> graph, final boolean[] isVisited, final int start) {
        final Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);
        isVisited[start] = true;

        while (!deque.isEmpty()) {
            final Integer poll = deque.pollLast();

            for (final Integer next : graph.get(poll)) {
                if (isVisited[next]) continue;

                deque.addLast(next);
                isVisited[next] = true;
            }
        }
    }
}
