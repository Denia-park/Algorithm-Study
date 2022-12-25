class Solution {
    final char UP = 'U';
    final char DOWN = 'D';
    final char LEFT = 'L';
    final char RIGHT = 'R';

    final char VERTICAL = '|';
    final char HORIZONTAL = '-';
    final char CROSS = '+';

    int gSize;

    public void solution(int size, String move) {
        gSize = size;
        char[][] board = new char[size][size];
        char[] moveChars = move.toCharArray();

        initBoard(board);

        Point p = new Point(0, 0);

        // 로봇 팔이 격자 바깥으로 나가도록 하는 움직임 명령을 만나면, 무시
        char saveDirec = ' ';
        char curMove = ' ';
        for (int i = 0; i < moveChars.length; i++) {
            curMove = moveChars[i];

            if (curMove == UP) {
                if (isOutOfBoard(p.r - 1, p.c)) continue;
                if (saveDirec == HORIZONTAL) {
                    board[p.r][p.c] = CROSS;
                } else {
                    board[p.r][p.c] = VERTICAL;
                }
                saveDirec = VERTICAL;
                p.r--;
                board[p.r][p.c] = VERTICAL;
            } else if (curMove == DOWN) {
                if (isOutOfBoard(p.r + 1, p.c)) continue;
                if (saveDirec == HORIZONTAL) {
                    board[p.r][p.c] = CROSS;
                } else {
                    board[p.r][p.c] = VERTICAL;
                }
                saveDirec = VERTICAL;
                p.r++;
                board[p.r][p.c] = VERTICAL;
            } else if (curMove == RIGHT) {
                if (isOutOfBoard(p.r, p.c + 1)) continue;
                if (saveDirec == VERTICAL) {
                    board[p.r][p.c] = CROSS;
                } else {
                    board[p.r][p.c] = HORIZONTAL;
                }
                saveDirec = HORIZONTAL;
                p.c++;
                board[p.r][p.c] = HORIZONTAL;
            } else if (curMove == LEFT) {
                if (isOutOfBoard(p.r, p.c - 1)) continue;
                if (saveDirec == VERTICAL) {
                    board[p.r][p.c] = CROSS;
                } else {
                    board[p.r][p.c] = HORIZONTAL;
                }
                saveDirec = HORIZONTAL;
                p.c--;
                board[p.r][p.c] = HORIZONTAL;
            }
        }

        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    private void initBoard(char[][] board) {
        for (int r = 0; r < gSize; r++) {
            for (int c = 0; c < gSize; c++) {
                board[r][c] = '.';
            }
        }
    }

    private boolean isOutOfBoard(int r, int c) {
        return r < 0 || r >= gSize || c < 0 || c >= gSize;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
