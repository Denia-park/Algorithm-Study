package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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
    final int WALL_COUNT = 1;
    final int K = WALL_COUNT + 1; // 1개까지 가능 => 즉 2개의 상태 [0,1]
    int answer, gRow, gCol;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][][] isVisited;
    char[][] gBoard;

    public void solution(int row, int col, char[][] board) {
        answer = Integer.MAX_VALUE;
        gRow = row;
        gCol = col;
        isVisited = new int[row][col][K];
        gBoard = board;

        bfs(0, 0);

        for (int i = 0; i < K; i++) {
            if (isVisited[row - 1][col - 1][i] == 0) {
                isVisited[row - 1][col - 1][i] = Integer.MAX_VALUE;
            }
            answer = Math.min(answer, isVisited[row - 1][col - 1][i]);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private void bfs(int row, int col) {
        Deque<Node> dq = new ArrayDeque<>();
        Node startNode = new Node(row, col, 1, 0);
        isVisited[startNode.row][startNode.col][startNode.brokenWallNum] = startNode.distance;
        dq.offerLast(startNode);

        while (!dq.isEmpty()) {
            Node curNode = dq.pollFirst();

            for (int[] direction : directions) {
                int nextRow = curNode.row + direction[0];
                int nextCol = curNode.col + direction[1];
                int nextBrokenWallNum = 0;
                int nextDistance = curNode.distance + 1;

                if (isOutOfBoard(nextRow, nextCol)) continue;

                if (gBoard[nextRow][nextCol] == '0') {
                    if (isVisited[nextRow][nextCol][curNode.brokenWallNum] != 0) continue;

                    nextBrokenWallNum = curNode.brokenWallNum;

                } else if (gBoard[nextRow][nextCol] == '1') {
                    if (curNode.brokenWallNum + 1 > WALL_COUNT) continue;
                    if (isVisited[nextRow][nextCol][curNode.brokenWallNum + 1] != 0) continue;

                    nextBrokenWallNum = curNode.brokenWallNum + 1;
                }
                isVisited[nextRow][nextCol][nextBrokenWallNum] = nextDistance;

                dq.offerLast(new Node(nextRow, nextCol, nextDistance, nextBrokenWallNum));
            }
        }
    }

    boolean isOutOfBoard(int row, int col) {
        return row < 0 || row >= gRow || col < 0 || col >= gCol;
    }
}

class Node {
    int row, col, distance, brokenWallNum;

    public Node(int row, int col, int distance, int brokenWallNum) {
        this.row = row;
        this.col = col;
        this.distance = distance;
        this.brokenWallNum = brokenWallNum;
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
