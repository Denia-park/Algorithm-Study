import java.util.PriorityQueue;

class Solution {
    final int SHARK = 9;
    final int SHARK_SIZE = 2;
    final int EMPTY = 0;
    int answer;

    public int solution(int size, int[][] table) {
        answer = 0;
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        Shark shark = null;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (table[r][c] == SHARK) {
                    shark = new Shark(r, c, SHARK_SIZE);
                } else if (table[r][c] != EMPTY) {
                    pq.add(new Fish(r, c, table[r][c]));
                }
            }
        }

        while (!pq.isEmpty()) {
            Fish fish = pq.poll();
            if (fish.size >= shark.size) {
                break;
            }
        }

        //bfs 가 필요할듯 ? => 최단거리
        return 0;
    }
}

class Shark {
    int row;
    int col;
    int size;

    public Shark(int row, int col, int size) {
        this.row = row;
        this.col = col;
        this.size = size;
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
