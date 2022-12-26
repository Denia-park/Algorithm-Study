class Solution {
    final char UP = 'U';
    final char DOWN = 'D';
    final char LEFT = 'L';
    final char RIGHT = 'R';

    int gSize;

    public void solution(int size, String quizMove) {
        gSize = size;
        char[][] board = new char[size][size];
        char[] moveChars = quizMove.toCharArray();

        initBoard(board);

        Point p = new Point(0, 0, board);

        char curMove = ' ';
        for (char move : moveChars) {
            curMove = move;

            if (curMove == UP) {
                if (isOutOfBoard(p.r - 1, p.c)) continue;

                p.draw(Pattern.VERTICAL);
                p.r--;
                p.draw(Pattern.VERTICAL);
            } else if (curMove == DOWN) {
                if (isOutOfBoard(p.r + 1, p.c)) continue;

                p.draw(Pattern.VERTICAL);
                p.r++;
                p.draw(Pattern.VERTICAL);
            } else if (curMove == RIGHT) {
                if (isOutOfBoard(p.r, p.c + 1)) continue;

                p.draw(Pattern.HORIZONTAL);
                p.c++;
                p.draw(Pattern.HORIZONTAL);
            } else if (curMove == LEFT) {
                if (isOutOfBoard(p.r, p.c - 1)) continue;

                p.draw(Pattern.HORIZONTAL);
                p.c--;
                p.draw(Pattern.HORIZONTAL);
            }
        }

        for (char[] chars : p.board) {
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
    char[][] board;

    public Point(int r, int c, char[][] board) {
        this.r = r;
        this.c = c;
        this.board = board;
    }

    public void draw(char curPattern) {
        if (this.board[this.r][this.c] == Pattern.CROSS)
            return;

        if (this.board[this.r][this.c] == Pattern.reverse(curPattern)) {
            this.board[this.r][this.c] = Pattern.CROSS;
        } else {
            this.board[this.r][this.c] = curPattern;
        }
    }
}

class Pattern {
    static final char VERTICAL = '|';
    static final char HORIZONTAL = '-';
    static final char CROSS = '+';

    static char reverse(char curPattern) {
        switch (curPattern) {
            case VERTICAL:
                return HORIZONTAL;
            case HORIZONTAL:
                return VERTICAL;
        }
        return curPattern;
    }
}
