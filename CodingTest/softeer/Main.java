package CodingTest.softeer;

import java.util.Scanner;

public class Main {

    static int[][] graph;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int size, count;
    static boolean[][] isVisited;
    static int max = 0;
    static Person[] People;

    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        count = sc.nextInt();

        graph = new int[size][size];
        isVisited = new boolean[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                graph[row][col] = sc.nextInt();
            }
        }
        People = new Person[count];

        int sum = 0;

        for (int i = 0; i < count; i++) {
            final int row = sc.nextInt() - 1;
            final int col = sc.nextInt() - 1;

            isVisited[row][col] = true;
            sum += graph[row][col];
            People[i] = new Person(row, col);
        }

        dfs(People[0].row, People[0].col, sum, 1);

        System.out.println(max);
    }

    public static void dfs(final int row, final int col, final int sum, final int depth) {
        if (depth == (4 * count)) {
            max = Math.max(max, sum);
            return;
        }

        if (depth % 4 == 0) {
            dfs(People[depth / 4].row, People[depth / 4].col, sum, depth + 1);
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            final int nextR = dir[i][0] + row;
            final int nextC = dir[i][1] + col;

            if (nextR >= 0 && nextC >= 0 && nextR < size && nextC < size && !isVisited[nextR][nextC]) {
                isVisited[nextR][nextC] = true;
                dfs(nextR, nextC, sum + graph[nextR][nextC], depth + 1);
                isVisited[nextR][nextC] = false;
            }
        }
    }

    static class Person {
        int row;
        int col;

        Person(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
