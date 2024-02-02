package CodingTest.softeer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int size, manCount;
    static int[][] board = new int[22][22];
    static int[][] visited = new int[22][22];
    static long sum = 0;
    static long ans = 0;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Man> manList = new ArrayList<>();

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        manCount = scanner.nextInt();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < manCount; i++) {
            final int manRow = scanner.nextInt();
            final int manCol = scanner.nextInt();
            sum += board[manRow][manCol];
            visited[manRow][manCol] = 1;
            manList.add(new Man(manRow, manCol));
        }
        dfs(manList.get(0).row, manList.get(0).col, 0, 0);
        System.out.println(ans);
        scanner.close();
    }

    static boolean canGo(final int nx, final int ny) {
        return nx >= 1 && ny >= 1 && nx <= size && ny <= size;
    }

    static void dfs(final int row, final int col, final int depth, final int id) {
        if (visited[row][col] == 0) sum += board[row][col];
        visited[row][col]++;

        if (depth == 3 && id < manCount - 1) {
            final Man man = manList.get(id + 1);
            dfs(man.row, man.col, 0, id + 1);
        } else if (depth == 3 && id == manCount - 1) {
            ans = Math.max(ans, sum);
        } else {
            for (final int[] offset : directions) {
                final int nextRow = row + offset[0];
                final int nextCol = col + offset[1];
                if (canGo(nextRow, nextCol)) {
                    dfs(nextRow, nextCol, depth + 1, id);
                }
            }
        }

        visited[row][col]--;
        if (visited[row][col] == 0) sum -= board[row][col];
    }

    static class Man {
        int row, col;

        Man(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}

