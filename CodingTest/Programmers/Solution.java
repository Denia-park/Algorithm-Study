package CodingTest.Programmers;

class Solution {
    int MOD = 20170805;

    public int solution(final int m, final int n, final int[][] cityMap) {
        final int row = m;
        final int col = n;

        final int[][] map = new int[m + 1][n + 1];

        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                if (r == 1 && c == 1) {
                    map[r][c] = 1;
                    continue;
                }

                //1면 못 지나가니까, 0으로 둔다.
                //2면 직선 거리만 가능하니까 그냥 둔다. (나중에 실제로 + 연산 할때 계산)
                if (cityMap[r - 1][c - 1] != 0) {
                    continue;
                }

                //왼쪽, cityMap은 원래 사이즈이므로 -1 해줘야함
                int tempR = r;
                int tempC = c - 1;
                while (tempC >= 1 && cityMap[tempR - 1][tempC - 1] == 2) {
                    tempC--;
                }
                final int left = map[tempR][tempC];

                //위쪽, cityMap은 원래 사이즈이므로 -1 해줘야함
                tempR = r - 1;
                tempC = c;
                while (tempR >= 1 && cityMap[tempR - 1][tempC - 1] == 2) {
                    tempR--;
                }
                final int up = map[tempR][tempC];

                map[r][c] = (left + up) % MOD;
            }
        }

        return map[row][col];
    }
}
