package CodingTest.Baekjoon;

//단지 번호 붙이기 2667

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        String[] map = new String[size];
        for (int i = 0; i < size; i++) {
            map[i] = br.readLine();
        }

        sol.solution(map, size);
    }
}

/*
아이디어
- DFS , BFS
- map 전체를 돌면서 확인
    - 0이면 무시, 방문 했으면 무시
    - 1이면 진입 후 DFS
        - 단지 사이즈 List에 넣기
- dfs 돌때
    - 0이면 무시, 방문했으면 무시, 맵 밖이면 무시
    - 방문 처리, 사이즈 1 올리기, 진행

- 출력
    - List 크기
    - Sort 후 출력

시간복잡도
- O(V + E)

자료구조
- BFS - Queue를 사용
- DFS - 재귀함수 사용
 */

class BjSolution {
    boolean[][] visited;
    List<Integer> answers;
    int tempSize;
    int mapSize;

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] map, int size) {
        visited = new boolean[size][size];
        answers = new ArrayList<>();
        mapSize = size;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char ch = map[r].charAt(c);

                if (ch == '0') continue;
                if (visited[r][c]) continue;

                tempSize = 0;
                visited[r][c] = true;
                dfs(map, r, c);
                answers.add(tempSize);
            }
        }

        answers.sort(null);
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()).append("\n");
        for (Integer answer : answers) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private void dfs(String[] map, int r, int c) {
        tempSize++;

        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];

            if (isOutOfMap(nextR, nextC) || map[nextR].charAt(nextC) == '0' || visited[nextR][nextC]) continue;

            visited[nextR][nextC] = true;
            dfs(map, nextR, nextC);
        }
    }

    private boolean isOutOfMap(int nextR, int nextC) {
        return nextR < 0 || nextR >= mapSize || nextC < 0 || nextC >= mapSize;
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
