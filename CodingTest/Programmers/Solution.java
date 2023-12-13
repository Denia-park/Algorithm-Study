package CodingTest.Programmers;

class Solution {
    public int solution(final String[][] board, final int row, final int col) {
        int answer = 0;

        final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        final String origin = board[row][col];

        for (final int[] direction : directions) {
            final int newRow = row + direction[0];
            final int newCol = col + direction[1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }

            if (origin.equals(board[newRow][newCol])) {
                answer++;
            }
        }

        return answer;
    }
}
