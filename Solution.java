import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] isVisited;
    int maxValue;
    int[][] table;
    private int gRow;
    private int gCol;

    public int solution(int row, int col, int[][] trashCoordinates) {
        gRow = row;
        gCol = col;
        table = new int[row][col];

        for (int[] trashCoordinate : trashCoordinates) {
            table[trashCoordinate[0] - 1][trashCoordinate[1] - 1] = 1;
        }

        maxValue = Integer.MIN_VALUE;
        isVisited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < gRow; r++) {
            for (int c = 0; c < gCol; c++) {
                if (table[r][c] == 0 || isVisited[r][c]) {
                    continue;
                }

                bfs(r, c, queue);
            }
        }

        return maxValue;
    }

    private void bfs(int row, int col, Queue<int[]> queue) {
        int tempCount = 0;

        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] curCoordinates = queue.poll();
            int curRow = curCoordinates[0];
            int curCol = curCoordinates[1];

            for (int[] dir : directions) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (isOutOfTable(newRow, newCol)) {
                    continue;
                }

                if (isVisited[newRow][newCol]) {
                    continue;
                }

                if (table[newRow][newCol] == 0) {
                    continue;
                }

                tempCount++;
                isVisited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
        }

        maxValue = Math.max(tempCount, maxValue);
    }

    boolean isOutOfTable(int row, int col) {
        return row < 0 || col < 0 || row >= gRow || col >= gCol;
    }
}
