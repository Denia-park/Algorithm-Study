package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        sol.solution(size);
        br.close();
    }
}

class BjSolution {
    int answer;
    int[] queen;
    int gSize;

    public void solution(int size) {
        answer = 0;
        gSize = size;
        queen = new int[size];

        simulate(0);


        System.out.println(answer);
    }

    private void simulate(int row) {
        if (isEndToPlace(row)) {
            answer++;
            return;
        }

        for (int col = 0; col < gSize; col++) {
            queen[row] = col;
            if (isAbleToPlace(row)) {
                simulate(row + 1);
            }
        }
    }

    private boolean isAbleToPlace(int curRow) {
        int curCol = queen[curRow];
        for (int preRow = 0; preRow < curRow; preRow++) {
            int preCol = queen[preRow];
            if (preCol == curCol || isDiagonal(preRow, preCol, curRow, curCol)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonal(int preRow, int preCol, int curRow, int curCol) {
        int diffRow = Math.abs(preRow - curRow);
        int diffCol = Math.abs(preCol - curCol);
        return diffRow == diffCol;
    }

    private boolean isEndToPlace(int row) {
        return row == gSize;
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

