package CodingTest.Programmers;
/*
아이디어 - bfs (최단거리 구하기)
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int[][] directions = {
            {-1, 0}, //북
            {0, 1}, //동
            {1, 0}, //남
            {0, -1}, //서
    };

    public int solution(final int[][] maps) {
        return bfs(maps);
    }

    //0은 벽, 1은 벽 X
    int bfs(final int[][] maps) {
        final int totalRow = maps.length;
        final int totalCol = maps[0].length;
        final boolean[][] isVisited = new boolean[totalRow][totalCol];

        final Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0, 0, 1});
        isVisited[0][0] = true;

        while (!dq.isEmpty()) {
            final int[] curPos = dq.pollFirst();
            final int curR = curPos[0];
            final int curC = curPos[1];
            final int curD = curPos[2];

            if (curR == totalRow - 1 && curC == totalCol - 1) {
                return curD;
            }

            for (final int[] nextVal : directions) {
                final int nextR = curR + nextVal[0];
                final int nextC = curC + nextVal[1];

                //map 밖으로 벗어나는지 확인
                if (nextR < 0 || nextR >= totalRow || nextC < 0 || nextC >= totalCol) continue;

                //1인지 아닌지 확인, 방문 했는지 확인
                if (maps[nextR][nextC] == 0 || isVisited[nextR][nextC]) continue;

                //다음으로 진행하고, 방문 체크
                dq.addLast(new int[]{nextR, nextC, curD + 1});
                isVisited[nextR][nextC] = true;
            }
        }

        return -1;
    }
}
