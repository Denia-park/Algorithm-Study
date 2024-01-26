package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.findPaths(
                2,
                2,
                2,
                0,
                0
        ));
        System.out.println("2 : " + solution.findPaths(
                1,
                3,
                3,
                0,
                1
        ));
    }
}

/*
아이디어
- DFS로 이동하면서 거리 더하기

시간복잡도
-

자료구조
-
 */

class Solution {
    static final int MOD = (int) (Math.pow(10, 9) + 7);
    int maxRow;
    int maxCol;
    int maxMove;
    int answer;

    int[][] directions = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int findPaths(final int m, final int n, final int maxMoveCount, final int startRow, final int startColumn) {
        maxRow = m;
        maxCol = n;
        maxMove = maxMoveCount;
        answer = 0;

        dfs(startRow, startColumn, 0);

        return answer;
    }

    private void dfs(final int curRow, final int curCol, final int curMoveCount) {
        if (curMoveCount > maxMove) {
            return;
        }

        if (isOut(curRow, curCol)) {
            answer = (answer + 1) % MOD;
            return;
        }

        for (final int[] direction : directions) {
            final int nextRow = curRow + direction[0];
            final int nextCol = curCol + direction[1];

            dfs(nextRow, nextCol, curMoveCount + 1);
        }
    }

    public boolean isOut(final int row, final int col) {
        return row < 0 || row >= maxRow || col < 0 || col >= maxCol;
    }
}
