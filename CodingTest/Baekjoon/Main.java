package CodingTest.Baekjoon;

//그림 1926

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int row = Integer.parseInt(splits[0]);
        int col = Integer.parseInt(splits[1]);

        String[][] graph = new String[row][col];
        for (int i = 0; i < row; i++) {
            graph[i] = br.readLine().split(" ");
        }

        sol.solution(graph, row, col);
    }
}

/*
아이디어
- DFS , BFS

시간복잡도
- O(V + E)

자료구조
- BFS - Queue를 사용
 */

class BjSolution {
    private boolean[][] visited;
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solution(String[][] graph, int row, int col) {
        int drawCount = 0;
        int maxDrawSize = 0;
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                String ch = graph[r][c];

                if (ch.equals("0")) continue;
                if (visited[r][c]) continue;

                drawCount++;
                maxDrawSize = Math.max(maxDrawSize, bfs(graph, r, c));
            }
        }

        System.out.println(drawCount);
        System.out.println(maxDrawSize);
    }

    private int bfs(String[][] graph, int r, int c) {
        int maxSize = 1;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r, c});
        visited[r][c] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int tempR = cur[0];
            int tempC = cur[1];

            for (int[] direction : directions) {
                int nextR = tempR + direction[0];
                int nextC = tempC + direction[1];

                if (isOutOfGraph(graph, nextR, nextC) || graph[nextR][nextC].equals("0") || visited[nextR][nextC])
                    continue;

                visited[nextR][nextC] = true;
                maxSize++;
                dq.add(new int[]{nextR, nextC});
            }
        }

        return maxSize;
    }

    private boolean isOutOfGraph(String[][] graph, int nextR, int nextC) {
        int row = graph.length;
        int col = graph[0].length;

        return nextR < 0 || nextR >= row || nextC < 0 || nextC >= col;
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
