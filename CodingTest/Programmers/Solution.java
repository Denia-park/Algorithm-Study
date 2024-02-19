package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int INF = 987654321;
    private static final int A = 1;
    private static final int B = 2;
    private final int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private int[][] board;

    public int solution(final int[][] bo, final int[] aloc, final int[] bloc) {
        board = bo;

        return Math.abs(solve(aloc[0], aloc[1], bloc[0], bloc[1], A));
    }

    private int solve(final int ar, final int ac, final int br, final int bc, final int turn) {
        final int row = turn == A ? ar : br;
        final int col = turn == A ? ac : bc;

        //최선의 경우 리턴
        final List<Integer> list = new ArrayList<>();

        for (final int[] direction : directions) {
            final int nR = row + direction[0];
            final int nC = col + direction[1];

            if (isOut(nR, nC) || board[nR][nC] == 0) {
                continue;
            }

            //현재 상대랑 나랑 같은 발판에 있는 경우 (움직일 경우 바로 끝남)
            if (ar == br && ac == bc) {
                list.add(1);
                continue;
            }

            //내가 움직인 곳 발판 사라짐
            board[row][col] = 0;

            //움직인다
            int res;
            if (turn == A) {
                res = -solve(nR, nC, br, bc, B);
            } else {
                res = -solve(ar, ac, nR, nC, A);
            }
            if (res >= 0) res++;
            else res--;
            list.add(res);

            //내가 움직인 곳 발판 다시 살림
            board[row][col] = 1;
        }

        int pMax = -INF, pMin = INF;
        int mMax = -INF, mMin = INF;
        for (final int num : list) {
            if (num > 0) {
                pMax = Math.max(pMax, num);
                pMin = Math.min(pMin, num);
            } else {
                mMax = Math.max(mMax, num);
                mMin = Math.min(mMin, num);
            }
        }

        if (pMax == -INF && mMax == -INF) return 0;
        else if (pMax == -INF) return mMin;
        else if (pMax != -INF) return pMin;
        else return 0; //불가능 컴파일 오류 제거
    }

    private boolean isOut(final int r, final int c) {
        return r < 0 || r >= board.length || c < 0 || c >= board[0].length;
    }
}
