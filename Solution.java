import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    int gSize;
    int[][] gTable;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int answer;

    public String solution(int size, int[][] table) {
        gSize = size;
        gTable = table;
        answer = Integer.MAX_VALUE;

        int[] minTable = new int[size * size];
        Arrays.fill(minTable, Integer.MAX_VALUE);

        Deque<Point> dq = new ArrayDeque<>();
        dq.push(new Point(0, 0, table[0][0], 0));

        while (!dq.isEmpty()) {
            Point p = dq.pop();
            int r = p.r;
            int c = p.c;
            int v = p.value;
            int d = p.depth;

            if (r == size - 1 && c == size - 1) {
                answer = Math.min(answer, v);
                continue;
            }

            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (isOutOfTable(nr, nc)) continue;

                if (d < (size * size) && minTable[d] > v + table[nr][nc]) {
                    minTable[d] = v + table[nr][nc];
                    dq.push(new Point(nr, nc, v + table[nr][nc], d + 1));
                }
            }
        }

        return String.valueOf(answer);
    }

    boolean isOutOfTable(int r, int c) {
        return r < 0 || c < 0 || r >= gSize || c >= gSize;
    }
}

class Point {
    int r;
    int c;
    int value;
    int depth;

    public Point(int r, int c, int value, int depth) {
        this.r = r;
        this.c = c;
        this.value = value;
        this.depth = depth;
    }
}
