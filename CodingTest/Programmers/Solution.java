package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final char PLAYER = 'P';
    private static final char EMPTY = 'O';
    private static final char WALL = 'X';
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public int[] solution(final String[][] places) {
        final int[] answer = new int[places.length];

        int idx = 0;
        for (final String[] map : places) {
            boolean isPass = true;

            //P인 모든 자리를 탐색
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[row].length(); col++) {
                    if (map[row].charAt(col) != PLAYER) {
                        continue;
                    }

                    isPass = bfs(map, row, col);

                    if (!isPass) {
                        break;
                    }
                }

                if (!isPass) {
                    break;
                }
            }

            answer[idx++] = isPass ? 1 : 0;
        }

        return answer;
    }

    private boolean bfs(final String[] map, final int row, final int col) {
        final Set<String> isVisited = new HashSet<>();
        final Deque<int[]> deque = new ArrayDeque<>();
        deque.push(new int[]{row, col, 0});
        isVisited.add(row + "," + col);

        while (!deque.isEmpty()) {
            final int[] cur = deque.poll();

            final int curRow = cur[0];
            final int curCol = cur[1];
            final int curDist = cur[2];

            if ((curRow != row && curCol != col)
                    && (map[curRow].charAt(curCol) == PLAYER)
                    && (curDist <= 2)) {
                return false;
            }

            for (final int[] direction : DIRECTIONS) {
                final int nextRow = curRow + direction[0];
                final int nextCol = curCol + direction[1];

                //밖으로 나가면 이동 못함
                if (isOutOfMap(map, nextRow, nextCol)) {
                    continue;
                }

                //벽이면 이동 못함
                if (map[nextRow].charAt(nextCol) == WALL) {
                    continue;
                }

                //방문 했으면 이동 못함
                if (isVisited.contains(nextRow + "," + nextCol)) {
                    continue;
                }

                //거리를 2까지만 확인한다.
                if (curDist >= 2) {
                    continue;
                }

                deque.push(new int[]{nextRow, nextCol, curDist + 1});
                //이동 하면 isVisted에 추가해주기
                isVisited.add(nextRow + "," + nextCol);
            }
        }

        return true;
    }

    private boolean isOutOfMap(final String[] map, final int nextRow, final int nextCol) {
        return nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[nextRow].length();
    }
}
