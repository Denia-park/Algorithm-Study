package CodingTest.Baekjoon;

//플로이드 11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = inputs[0];
        int col = inputs[1];

        int[][] matrix = new int[row][col];

        for (int r = 0; r < row; r++) {
            int[] rows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(rows, 0, matrix[r], 0, col);
        }

        sol.solve(row, col, matrix);
    }
}

//아이디어

//시간복잡도

//자료구조

class BjSolution {
    int[] dR = {0, 1, 0, -1};
    int[] dC = {1, 0, -1, 0};
    boolean[][] visited;

    public void solve(int row, int col, int[][] matrix) {
        int count = 0;
        int maxSize = 0;
        visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                //1이 아니면 탐색X
                if (matrix[r][c] == 0) continue;
                //이미 방문햇으면 탐색X
                if (visited[r][c]) continue;

                count++;
                maxSize = Math.max(bfs(r, c, matrix), maxSize);
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private int bfs(int r, int c, int[][] matrix) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{r, c});
        visited[r][c] = true;
        int maxSize = 1;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cR = cur[0];
            int cC = cur[1];

            for (int i = 0; i < 4; i++) {
                int newR = cR + dR[i];
                int newC = cC + dC[i];

                //map 벗어나면 탐색 X
                if (newR < 0 || newR >= matrix.length || newC < 0 || newC >= matrix[0].length)
                    continue;

                //0이면 탐색 X
                if (matrix[newR][newC] == 0)
                    continue;

                //이미 방문했으면 탐색 X
                if (visited[newR][newC])
                    continue;

                //방문처리 + 사이즈 1 추가
                dq.addLast(new int[]{newR, newC});
                maxSize++;
                visited[newR][newC] = true;
            }
        }

        return maxSize;
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
