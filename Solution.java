import java.util.PriorityQueue;

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

        out:
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (table[r][c] == SHARK) {
                    shark = new Shark(r, c, SHARK_SIZE);
                    table[r][c] = 0;
                    break out;
                }
            }
        }

        while (true) {
            if (!findFishToEatByBFS()) {
                break;
            }
        }

        return answer;
    }

    boolean findFishToEatByBFS() {
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int curSharkSize = shark.size;
        boolean[][] tempVisited = new boolean[gSize][gSize];
        PriorityQueue<Fish> queue = new PriorityQueue<>();

        tempVisited[shark.row][shark.col] = true;
        queue.add(new Fish(shark.row, shark.col, 0, false));

        while (!queue.isEmpty()) {
            Fish fish = queue.poll();

            if (fish.eatFlag) {
                gTable[fish.row][fish.col] = 0;
                shark.row = fish.row;
                shark.col = fish.col;
                answer += fish.distance;
                shark.eat();
                return true;
            }

            for (int[] direction : directions) {
                int newRow = fish.row + direction[0];
                int newCol = fish.col + direction[1];

                if (isOutOfTable(newRow, newCol)) continue;

                int newFishSize = gTable[newRow][newCol];
                if (!tempVisited[newRow][newCol] && newFishSize <= curSharkSize) {
                    tempVisited[newRow][newCol] = true;
                    if (0 < newFishSize && newFishSize < curSharkSize) {
                        queue.add(new Fish(newRow, newCol, fish.distance + 1, true));
                    } else {
                        queue.add(new Fish(newRow, newCol, fish.distance + 1, false));
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

class Fish implements Comparable<Fish> {
    int row;
    int col;
    int distance;
    boolean eatFlag;

    public Fish(int row, int col, int distance, boolean eatFlag) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.eatFlag = eatFlag;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.distance == o.distance) {
            if (this.row == o.row) {
                return Integer.compare(this.col, o.col);
            }
            return Integer.compare(this.row, o.row);
        }
        return Integer.compare(this.distance, o.distance);
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

