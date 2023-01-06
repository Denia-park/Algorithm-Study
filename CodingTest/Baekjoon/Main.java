package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNum; i++) {
            int row = Integer.parseInt(br.readLine());
            int col = Integer.parseInt(br.readLine()); // 1호 부터 산다.
            sol.solution(row, col);
        }
    }
}

class BjSolution {
    public void solution(int row, int col) {
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i < col + 1; i++) {
            dp[0][i] = i;
        }

        for (int r = 1; r < row + 1; r++) {
            for (int c = 1; c < col + 1; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        System.out.println(dp[row][col]);
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
