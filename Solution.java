import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    final int SHARK = 9;
    final int SHARK_SIZE = 2;
    final int EMPTY = 0;
    int answer;
    Shark shark;
    int[][] gTable;
    int gSize;

    public int solution(int size, int[][] table) {
        answer = 0;
        gSize = size;
        shark = null;
        gTable = table;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (table[r][c] == SHARK) {
                    shark = new Shark(r, c, SHARK_SIZE);
                    break;
                }
            }
        }

        while (true) {
            if (!bfs()) {
                break;
            }
        }

        //bfs 가 필요할듯 ? => 최단거리
        return answer;
    }

    boolean bfs() {
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int curSharkSize = shark.size;
        boolean[][] tempVisited = new boolean[gSize][gSize];
        Deque<Coordi> queue = new ArrayDeque<>();

        tempVisited[shark.row][shark.col] = true;
        queue.addLast(new Coordi(shark.row, shark.col, 0));

        while (!queue.isEmpty()) {
            Coordi coordi = queue.poll();

            int tempFishSize = gTable[coordi.row][coordi.col];

            if (tempFishSize != 0 && tempFishSize < curSharkSize) {
                gTable[coordi.row][coordi.col] = 0;
                answer += coordi.distance;
                shark.eat();
                return true;
            }

            for (int[] direction : directions) {
                int newRow = coordi.row + direction[0];
                int newCol = coordi.col + direction[1];

                if (isOutOfTable(newRow, newCol)) continue;

                int newFishSize = gTable[newRow][newCol];
                if (!tempVisited[newRow][newCol] && newFishSize != 0 && newFishSize <= curSharkSize) {
                    tempVisited[newRow][newCol] = true;
                    queue.add(new Coordi(newRow, newCol, coordi.distance + 1));
                }
            }
        }

        return false;
    }

    boolean isOutOfTable(int row, int col) {
        return row < 0 || col < 0 || row >= gSize || col >= gSize;
    }
}

class Coordi {
    int row;
    int col;
    int distance;

    public Coordi(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Shark {
    int row;
    int col;
    int size;
    int eatCount;

    public Shark(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
        eatCount = 0;
    }

    public void eat() {
        eatCount++;
        if (eatCount == size) {
            size++;
        }
    }
}

