package CodingTest.Programmers;

class Solution {
    private static final int A = 1;
    private static final int B = 2;
    private final int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private int answer;
    private int[][] board;

    public int solution(final int[][] bo, final int[] aloc, final int[] bloc) {
        answer = -1;
        board = bo;

        simul(aloc, bloc, A, 0);

        return answer;
    }

    private void simul(final int[] aloc, final int[] bloc, final int order, final int count) {
        final int[] manLoc = order == A ? aloc : bloc;
        final int row = manLoc[0];
        final int col = manLoc[1];

        //누군가 있다가 나가면 맵이 부숴짐 => 패배함 (answer 업데이트)
        if (board[row][col] == 0) {
            answer = Math.max(answer, count);
            return;
        }

        //밖으로 나가면 안되고, 발판이 있는 곳만 움직일 수 있음
        boolean moveFlag = false;
        for (final int[] direction : directions) {
            final int nR = row + direction[0];
            final int nC = col + direction[1];

            if (isOut(nR, nC) || board[nR][nC] == 0) {
                continue;
            }

            moveFlag = true;
            //내가 움직인 곳 발판 사라짐
            board[row][col] = 0;

            //움직인다
            if (order == A) {
                simul(new int[]{nR, nC}, bloc, B, count + 1);
            } else {
                simul(aloc, new int[]{nR, nC}, A, count + 1);
            }

            //내가 움직인 곳 발판 다시 살림
            board[row][col] = 1;
        }

        //내가 못 움직임 => 패배함 (answer 업데이트)
        if (!moveFlag) {
            answer = Math.max(answer, count);
        }
    }

    private boolean isOut(final int r, final int c) {
        return r < 0 || r >= board.length || c < 0 || c >= board[0].length;
    }
}
