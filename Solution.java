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
                    table[r][c] = 0;
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
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int curSharkSize = shark.size;
        boolean[][] tempVisited = new boolean[gSize][gSize];
        Deque<Coordi> queue = new ArrayDeque<>();

        tempVisited[shark.row][shark.col] = true;
        queue.addLast(new Coordi(shark.row, shark.col, 0, false));

        while (!queue.isEmpty()) {
            Coordi coordi = queue.poll();

            if (coordi.eatFlag) {
                gTable[coordi.row][coordi.col] = 0;
                shark.row = coordi.row;
                shark.col = coordi.col;
                answer += coordi.distance;
                shark.eat();
                return true;
            }

            for (int[] direction : directions) {
                int newRow = coordi.row + direction[0];
                int newCol = coordi.col + direction[1];

                if (isOutOfTable(newRow, newCol)) continue;

                int newFishSize = gTable[newRow][newCol];
                if (!tempVisited[newRow][newCol] && newFishSize <= curSharkSize) {
                    tempVisited[newRow][newCol] = true;
                    if (0 < newFishSize && newFishSize < curSharkSize) {
                        queue.add(new Coordi(newRow, newCol, coordi.distance + 1, true));
                    } else {
                        queue.add(new Coordi(newRow, newCol, coordi.distance + 1, false));
                    }
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
    boolean eatFlag;

    public Coordi(int row, int col, int distance, boolean eatFlag) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.eatFlag = eatFlag;
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
            eatCount = 0;
            size++;
        }
    }
}

