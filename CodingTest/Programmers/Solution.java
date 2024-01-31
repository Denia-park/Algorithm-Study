package CodingTest.Programmers;

/*
아이디어 - BFS
네트워크 개수 구하기
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(final int n, final int[][] computers) {
        int answer = 0;
        final boolean[] isVisited = new boolean[n];

        //네트워크 파악을 위해 0 ~ n-1 까지 순회
        for (int start = 0; start < n; start++) {
            if (isVisited[start]) continue;

            bfs(computers, isVisited, start);
            answer++;
        }

        return answer;
    }

    private void bfs(final int[][] computers, final boolean[] isVisited, final int start) {
        final Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);
        isVisited[start] = true;

        while (!deque.isEmpty()) {
            final Integer poll = deque.pollLast();

            final int[] computer = computers[poll];

            for (int next = 0; next < computer.length; next++) {
                final Integer isAble = computer[next];
                if (isVisited[next] || isAble == 0) continue;

                deque.addLast(next);
                isVisited[next] = true;
            }
        }
    }
}
