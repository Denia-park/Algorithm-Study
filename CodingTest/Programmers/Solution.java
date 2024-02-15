package CodingTest.Programmers;

class Solution {
    static final int ATTACK = 1;
    static final int HEAL = 2;

    public int solution(final int[][] board, final int[][] skill) {
        int answer = 0;

        //skill을 다 적용
        for (final int[] ints : skill) {
            final int type = ints[0] == ATTACK ? -1 : 1;
            final int r1 = ints[1];
            final int c1 = ints[2];
            final int r2 = ints[3];
            final int c2 = ints[4];
            final int degree = ints[5];

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    board[r][c] += type * degree;
                }
            }
        }

        //멀쩡한 건물의 수를 센다.
        for (final int[] ints : board) {
            for (final int val : ints) {
                if (val > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
