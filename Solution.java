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

        char curMove = ' ';
        for (char moveChar : moveChars) {
            curMove = moveChar;

            if (curMove == UP) {
                if (isOutOfBoard(p.r - 1, p.c)) continue;

                if (board[p.r][p.c] == HORIZONTAL) board[p.r][p.c] = CROSS;
                else if (board[p.r][p.c] == CROSS) ;
                else board[p.r][p.c] = VERTICAL;

                if (board[p.r - 1][p.c] == HORIZONTAL) board[p.r - 1][p.c] = CROSS;
                else if (board[p.r - 1][p.c] == CROSS) ;
                else board[p.r - 1][p.c] = VERTICAL;

                p.r--;
            } else if (curMove == DOWN) {
                if (isOutOfBoard(p.r + 1, p.c)) continue;

                if (board[p.r][p.c] == HORIZONTAL) board[p.r][p.c] = CROSS;
                else if (board[p.r][p.c] == CROSS) ;
                else board[p.r][p.c] = VERTICAL;

                if (board[p.r + 1][p.c] == HORIZONTAL) board[p.r + 1][p.c] = CROSS;
                else if (board[p.r + 1][p.c] == CROSS) ;
                else board[p.r + 1][p.c] = VERTICAL;

                p.r++;
            } else if (curMove == RIGHT) {
                if (isOutOfBoard(p.r, p.c + 1)) continue;

                if (board[p.r][p.c] == VERTICAL) board[p.r][p.c] = CROSS;
                else if (board[p.r][p.c] == CROSS) ;
                else board[p.r][p.c] = HORIZONTAL;

                if (board[p.r][p.c + 1] == VERTICAL) board[p.r][p.c + 1] = CROSS;
                else if (board[p.r][p.c + 1] == CROSS) ;
                else board[p.r][p.c + 1] = HORIZONTAL;

                p.c++;
            } else if (curMove == LEFT) {
                if (isOutOfBoard(p.r, p.c - 1)) continue;

                if (board[p.r][p.c] == VERTICAL) board[p.r][p.c] = CROSS;
                else if (board[p.r][p.c] == CROSS) ;
                else board[p.r][p.c] = HORIZONTAL;

                if (board[p.r][p.c - 1] == VERTICAL) board[p.r][p.c - 1] = CROSS;
                else if (board[p.r][p.c - 1] == CROSS) ;
                else board[p.r][p.c - 1] = HORIZONTAL;

                p.c--;
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
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
