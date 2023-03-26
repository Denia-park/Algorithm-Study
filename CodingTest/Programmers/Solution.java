package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int ROW, COL;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    char[][] map;
    int[] start, goal;
    private int answer;

    public int solution(String[] board) {
        answer = Integer.MAX_VALUE;
        ROW = board.length;
        COL = board[0].length();
        visited = new boolean[ROW][COL];
        this.map = new char[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                char ch = board[r].charAt(c);
                map[r][c] = ch;

                if (ch == 'R') {
                    start = new int[]{r, c};
                } else if (ch == 'G') {
                    goal = new int[]{r, c};
                }
            }
        }

        visited[start[0]][start[1]] = true;
        bfs(start[0], start[1], 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void bfs(int curRow, int curCol, int cnt) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{curRow, curCol, cnt});

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cR = cur[0];
            int cC = cur[1];
            int cCnt = cur[2];

            if (cR == goal[0] && cC == goal[1]) {
                answer = Math.min(answer, cCnt);
                return;
            }

            for (int direction = 0; direction < directions.length; direction++) {
                int[] nextRowCol = goStraight(cR, cC, direction);
                int nextRow = nextRowCol[0];
                int nextCol = nextRowCol[1];

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                deque.add(new int[]{nextRow, nextCol, cCnt + 1});
            }
        }
    }

    private int[] goStraight(int curRow, int curCol, int direction) {
        while (true) {
            int nextRow = curRow + directions[direction][0];
            int nextCol = curCol + directions[direction][1];

            if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 'D') {
                break;
            }

            curRow += directions[direction][0];
            curCol += directions[direction][1];
        }

        return new int[]{curRow, curCol};
    }

    private boolean isOutOfMap(int nextRow, int nextCol) {
        return nextRow < 0 || nextRow >= ROW || nextCol < 0 || nextCol >= COL;
    }
}
