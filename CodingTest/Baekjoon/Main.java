package CodingTest.Baekjoon;

//단지 번호 붙이기 - 2667

//계획
//2중 for문으로 "1인 곳, 아직 방문하지 않은" 집만 확인 후 DFS를 돈다.
//      - DFS를 돌면서 단지의 사이즈를 확인하고 max값을 출력한다.
//      - max 단지 값을 List에 저장 후 sort하고 출력한다.

//출력
//단지 출력
//단지에 속하는 집을 오름차순으로 "정렬" 후 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mapSize = Integer.parseInt(br.readLine());
        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            String input = br.readLine();
            int tempIdx = 0;
            for (char ch : input.toCharArray()) {
                map[i][tempIdx++] = ch - '0';
            }
        }

        sol.solution(map);
    }
}

class BjSolution {
    int gMapSize;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    List<Integer> answers;
    int visitCount;

    public void solution(int[][] map) {
        gMapSize = map.length;
        visited = new boolean[gMapSize][gMapSize];
        answers = new ArrayList<>();


        for (int row = 0; row < gMapSize; row++) {
            for (int col = 0; col < gMapSize; col++) {
                if (map[row][col] == 0 || visited[row][col]) continue;

                visitCount = 1;
                visited[row][col] = true;
                dfs(map, row, col);
                answers.add(visitCount);
            }
        }

        System.out.println(answers.size());
        answers.sort(null);
        for (Integer val : answers) {
            System.out.println(val);
        }
    }

    private void dfs(int[][] map, int row, int col) {
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isOutOfMap(nextRow, nextCol) || map[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) continue;

            visited[nextRow][nextCol] = true;
            visitCount++;
            dfs(map, nextRow, nextCol);
        }
    }

    private boolean isOutOfMap(int row, int col) {
        return row < 0 || row >= gMapSize || col < 0 || col >= gMapSize;
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
