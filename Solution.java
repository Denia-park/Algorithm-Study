import java.util.*;

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

        PriorityQueue<Fish> fishPQ = new PriorityQueue<>();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (table[r][c] == SHARK) {
                    shark = new Shark(r, c, SHARK_SIZE);
                } else if (table[r][c] != EMPTY) {
                    fishPQ.add(new Fish(r, c, table[r][c]));
                }
            }
        }

        while (!fishPQ.isEmpty()) {
            Fish fish = fishPQ.poll();
            int curFishSize = fish.size;

            List<Fish> fishList = new ArrayList<>();
            fishList.add(fish);

            while (true) {
                if (!fishPQ.isEmpty() && fishPQ.peek().size == curFishSize) {
                    fishList.add(fishPQ.poll());
                    continue;
                }
                break;
            }

            fishList.sort(new Comparator<Fish>() {
                @Override
                public int compare(Fish o1, Fish o2) {
                    int o1Distance = Math.abs(shark.row - o1.row) + Math.abs(shark.col - o1.col);
                    int o2Distance = Math.abs(shark.row - o2.row) + Math.abs(shark.col - o2.col);

                    if (o1Distance != o2Distance) {
                        return o1Distance - o2Distance;
                    } else {
                        if (o1.row == o2.row) {
                            return Integer.compare(o1.col, o2.col);
                        } else {
                            return Integer.compare(o1.row, o2.row);
                        }
                    }
                }
            });

            if (curFishSize >= shark.size) {
                break;
            }

            for (Fish fish1 : fishList) {
                bfs(fish1);
            }
        }

        //bfs 가 필요할듯 ? => 최단거리
        return answer;
    }

    void bfs(Fish targetFish) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int curSharkSize = shark.size;
        boolean[][] tempVisited = new boolean[gSize][gSize];
        int targetRow = targetFish.row;
        int targetCol = targetFish.col;
        Deque<Coordi> queue = new ArrayDeque<>();

        tempVisited[shark.row][shark.col] = true;
        queue.add(new Coordi(shark.row, shark.col, 0));

        while (!queue.isEmpty()) {
            Coordi coordi = queue.poll();

            if (coordi.row == targetRow && coordi.col == targetCol) {
                answer += coordi.distance;
                shark.eat();
                break;
            }

            for (int[] direction : directions) {
                int newRow = coordi.row + direction[0];
                int newCol = coordi.col + direction[1];

                if (isOutOfTable(newRow, newCol)) continue;

                int fishSize = gTable[newRow][newCol];
                if (!tempVisited[newRow][newCol] && fishSize <= curSharkSize) {
                    tempVisited[newRow][newCol] = true;
                    queue.add(new Coordi(newRow, newCol, coordi.distance + 1));
                }
            }
        }
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

class Fish implements Comparable<Fish> {
    int row;
    int col;
    int size;

    public Fish(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
    }

    @Override
    public int compareTo(Fish o) {
        return Integer.compare(size, o.size);
    }
}
