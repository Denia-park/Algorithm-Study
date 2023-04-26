package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int row = Integer.parseInt(inputs[0]);
        int col = Integer.parseInt(inputs[1]);
        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            inputs = br.readLine().split(" ");
            int tempIdx = 0;
            for (String input : inputs) {
                map[i][tempIdx++] = Integer.parseInt(input);
            }
        }

        sol.solution(map);
    }
}

class BjSolution {
    int gRow;
    int gCol;
    int drawCount;
    int maxDrawWidth;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public void solution(int[][] map) {
        gRow = map.length;
        gCol = map[0].length;

        drawCount = 0;
        maxDrawWidth = 0;

        visited = new boolean[gRow][gCol];

        for (int row = 0; row < gRow; row++) {
            for (int col = 0; col < gCol; col++) {
                if (map[row][col] == 0 || visited[row][col]) continue;

                bfs(map, row, col);
                drawCount++;
            }
        }

        System.out.println(drawCount);
        System.out.println(maxDrawWidth);
    }

    private void bfs(int[][] map, int row, int col) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        int tempWidth = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            tempWidth++;

            for (int[] direction : directions) {
                int nextRow = curRow + direction[0];
                int nextCol = curCol + direction[1];
                if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol});
            }
        }

        maxDrawWidth = Math.max(maxDrawWidth, tempWidth);
    }

    private boolean isOutOfMap(int row, int col) {
        return row < 0 || row >= gRow || col < 0 || col >= gCol;
    }
}

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }
