package CodingTest.Programmers;

//https://school.programmers.co.kr/questions/25471

class Solution {
    static final int ATTACK = 1;
    static final int HEAL = 2;

    public int solution(final int[][] board, final int[][] skill) {
        int answer = 0;

        final int[][] newBoard = new int[board.length + 1][board[0].length + 1];

        //누적합 구하기
        //(r1, c1) ~ (r2, c2) 좌표에 n의 값을 변화주고 싶다.
        //r1, c1 = n
        //r1, c2 + 1 = -n
        //r2 + 1, c1 = -n
        //r2 + 1 , c2 + 1 = n

        //오른쪽으로 다 더하고 아래쪽으로 더하기

        //skill을 다 적용
        for (final int[] ints : skill) {
            final int type = ints[0] == ATTACK ? -1 : 1;
            final int r1 = ints[1];
            final int c1 = ints[2];
            final int r2 = ints[3];
            final int c2 = ints[4];
            final int degree = ints[5];

            final int add = type * degree;

            newBoard[r1][c1] += add;
            newBoard[r1][c2 + 1] -= add;
            newBoard[r2 + 1][c1] -= add;
            newBoard[r2 + 1][c2 + 1] += add;
        }

        //누적합 계산
        for (int r = 0; r < newBoard.length; r++) {
            for (int c = 1; c < newBoard[0].length; c++) {
                newBoard[r][c] += newBoard[r][c - 1];
            }
        }

        for (int c = 0; c < newBoard[0].length; c++) {
            for (int r = 1; r < newBoard.length; r++) {
                newBoard[r][c] += newBoard[r - 1][c];
            }
        }

        //멀쩡한 건물의 수를 센다.
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                final int sum = newBoard[r][c] + board[r][c];

                if (sum > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
