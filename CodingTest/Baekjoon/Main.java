package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        int specialNum = Integer.parseInt(line[2]);

        sol.solution(rows, cols, specialNum);
    }
}

class BjSolution {
    int answer, gRows, gCols, gSpecialNum;
    int[][] directions = {{0, 1}, {1, 0}};
    int[][] grid;

    public void solution(int rows, int cols, int specialNum) {
        answer = 0;
        gRows = rows;
        gCols = cols;
        gSpecialNum = specialNum;

        grid = new int[rows][cols];

        int tempVal = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = tempVal;
                tempVal++;
            }
        }

        dfs(0, 0, false);

        System.out.println(answer);
    }

    private void dfs(int r, int c, boolean checkFlag) {
        if (r == gRows - 1 && c == gCols - 1) {
            if (gSpecialNum != 0) {
                if (checkFlag)
                    answer++;
            } else {
                answer++;
            }
            return;
        }

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr >= 0 && nr < gRows && nc >= 0 && nc < gCols) {
                boolean tempCheckFlag = checkFlag || grid[nr][nc] == gSpecialNum;
                dfs(nr, nc, tempCheckFlag);
            }
        }
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
