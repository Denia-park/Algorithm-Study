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
        int size = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                int tempVal = Integer.parseInt(line[j]);
                arr[i][j] = tempVal;
                max = Math.max(max, tempVal);
            }
        }

        sol.solution(arr, max);
    }
}

class BjSolution {
    private int answer, safeZoneCount;
    private int[][] map;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] isVisited;

    public void solution(int[][] inputs, int max) {
        answer = 0;
        map = inputs;

        for (int dangerLine = 0; dangerLine < max; dangerLine++) {
            isVisited = new boolean[map.length][map[0].length];
            safeZoneCount = 0;

            for (int r = 0; r < inputs.length; r++) {
                for (int c = 0; c < inputs[0].length; c++) {
                    if (map[r][c] <= dangerLine || isVisited[r][c]) continue;

                    isVisited[r][c] = true;
                    safeZoneCount++;
                    bfs(r, c, dangerLine);
                }
            }

            answer = Math.max(answer, safeZoneCount);
        }

        System.out.println(answer);
    }

    private void bfs(int r, int c, int dangerLine) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{r, c});

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();

            for (int[] dir : directions) {
                int nextR = cur[0] + dir[0];
                int nextC = cur[1] + dir[1];
                if (isOutOfMap(nextR, nextC) || isVisited[nextR][nextC]) {
                    continue;
                }

                if (map[nextR][nextC] > dangerLine) {
                    isVisited[nextR][nextC] = true;
                    deque.offerLast(new int[]{nextR, nextC});
                }
            }
        }
    }

    private boolean isOutOfMap(int r, int c) {
        return r < 0 || r >= map.length || c < 0 || c >= map[0].length;
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
