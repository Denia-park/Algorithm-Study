package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    private int SIZE;
    private int[] rows;
    private int answer;

    public int solution(int n) {
        answer = 0;
        SIZE = n;

        for (int col = 0; col < n; col++) {
            rows = new int[n];
            Arrays.fill(rows, -1);

            nQueen(0, col);
        }

        return answer;
    }

    private void nQueen(int row, int col) {
        if (row == SIZE - 1) {
            answer++;
            return;
        }

        rows[row] = col;

        for (int c = 0; c < SIZE; c++) {
            if (isNotAvailableToPlace(row + 1, c)) {
                continue;
            }
            nQueen(row + 1, c);
        }

    }

    private boolean isNotAvailableToPlace(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (isSameRow(r, col) || isDiagonal(r, row, col)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSameRow(int row, int col) {
        return rows[row] == col;
    }

    private boolean isDiagonal(int r, int row, int col) {
        return Math.abs(r - row) == Math.abs(rows[r] - col);
    }
}
