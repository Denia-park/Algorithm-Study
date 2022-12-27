import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    int gSize;
    int[][] gTable;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int answer;

    public String solution(int size, int[][] table) {
        gSize = size;
        gTable = table;
        answer = Integer.MAX_VALUE;

        int[][] dijkstra = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dijkstra[i], Integer.MAX_VALUE);
        }

        dijkstra[0][0] = table[0][0];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, table[0][0]));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int r = p.r;
            int c = p.c;

            for (int[] direction : directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                if (isOutOfTable(nr, nc)) continue;

                if (dijkstra[nr][nc] > dijkstra[r][c] + table[nr][nc]) {
                    dijkstra[nr][nc] = dijkstra[r][c] + table[nr][nc];
                    pq.add(new Point(nr, nc, dijkstra[nr][nc]));
                }
            }
        }

        return String.valueOf(dijkstra[size - 1][size - 1]);
    }

    boolean isOutOfTable(int r, int c) {
        return r < 0 || c < 0 || r >= gSize || c >= gSize;
    }
}

class Point implements Comparable<Point> {
    int r;
    int c;
    int value;

    public Point(int r, int c, int value) {
        this.r = r;
        this.c = c;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.value, o.value);
    }
}
