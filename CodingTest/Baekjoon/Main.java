package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        char[][] board = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        sol.solution(row, col, board);
    }
}

class BjSolution {
    int answer, gRow, gCol;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean isBrokenWall;
    boolean[][] isVisited;
    char[][] gBoard;

    public void solution(int row, int col, char[][] board) {
        answer = Integer.MAX_VALUE;
        gRow = row;
        gCol = col;
        isBrokenWall = false;
        isVisited = new boolean[row][col];
        gBoard = board;

        dfs(0, 0, 1);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private void dfs(int row, int col, int distance) {
        if (row == gRow - 1 && col == gCol - 1) {
            answer = Math.min(answer, distance);
            return;
        }

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isOutOfBoard(nextRow, nextCol)) continue;

            if (gBoard[nextRow][nextCol] == '1' && !isBrokenWall) {
                if (isVisited[nextRow][nextCol]) continue;

                isBrokenWall = true;
                isVisited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, distance + 1);
            } else if (gBoard[nextRow][nextCol] == '0') {
                if (isVisited[nextRow][nextCol]) continue;
                isVisited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, distance + 1);
            }
        }
    }

    boolean isOutOfBoard(int row, int col) {
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
