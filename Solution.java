import java.util.PriorityQueue;

class Solution {
    final int SHARK = 9;
    final int SHARK_SIZE = 2;
    int answer;
    Shark shark;
    int[][] gTable;
    int gSize;
    boolean[][] visited;

    public int solution(int size, int[][] table) {
        answer = 0;
        gSize = size;
        shark = null;
        gTable = table;

        shark = findShark();

        while (true) {
            if (!isFoundFishToEatByBFS()) break;
        }

        return answer;
    }

    private Shark findShark() {
        for (int r = 0; r < gSize; r++) {
            for (int c = 0; c < gSize; c++) {
                if (gTable[r][c] == SHARK) {
                    gTable[r][c] = 0;
                    return shark = new Shark(r, c, SHARK_SIZE);
                }
            }
        }

        return null;
    }

    boolean isFoundFishToEatByBFS() {
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        visited = new boolean[gSize][gSize];
        PriorityQueue<Fish> pq = new PriorityQueue<>();

        visited[shark.row][shark.col] = true;
        pq.add(new Fish(shark.row, shark.col, 0, false));

        while (!pq.isEmpty()) {
            Fish fish = pq.poll();
            int fishDis = fish.distance;

            if (fish.eatFlag) {
                gTable[fish.row][fish.col] = 0;
                shark.move(fish.row, fish.col);
                shark.eat();
                answer += fish.distance;
                return true;
            }

            for (int[] direction : directions) {
                int newR = fish.row + direction[0];
                int newC = fish.col + direction[1];

                if (isOutOfTable(newR, newC)) continue;

                int fishSize = gTable[newR][newC];
                if (!visited[newR][newC] && shark.isMovable(fishSize)) {
                    visited[newR][newC] = true;
                    pq.add(new Fish(newR, newC, fishDis + 1, shark.isEatable(fishSize)));
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
    int row, col, distance;
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
    int row, col, size, eatCount;

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

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isMovable(int fishSize) {
        return fishSize <= this.size;
    }

    public boolean isEatable(int fishSize) {
        return 0 < fishSize && fishSize < this.size;
    }
}

