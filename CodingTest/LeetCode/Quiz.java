package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.cherryPickup(
                new int[][]{
                        {3, 1, 1},
                        {2, 5, 1},
                        {1, 5, 5},
                        {2, 1, 1}
                }
        ));

        System.out.println(solution.cherryPickup(
                new int[][]{
                        {1, 0, 0, 0, 0, 0, 1},
                        {2, 0, 0, 0, 0, 3, 0},
                        {2, 0, 9, 0, 0, 0, 0},
                        {0, 3, 0, 5, 4, 0, 0},
                        {1, 0, 2, 3, 0, 0, 6}
                }
        ));
    }
}

class Solution {
    int rowLen;
    int colLen;
    Integer[][][] dp;

    public int cherryPickup(final int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;
        dp = new Integer[rowLen + 1][colLen + 1][colLen + 1];

        return calculate(grid, 0, 0, colLen - 1);
    }

    private int calculate(final int[][] grid, final int currRow, final int aCol, final int bCol) {
        if (aCol < 0 || bCol < 0 ||
                aCol >= colLen || bCol >= colLen) return 0;

        if (currRow == rowLen) return 0; // last row

        int result = 0;
        result += grid[currRow][aCol];
        result += grid[currRow][bCol];

        int max = 0; //DFS for next row;
        for (int aC = aCol - 1; aC <= aCol + 1; aC++) {
            for (int bC = bCol - 1; bC <= bCol + 1; bC++) {
                if (aC < bC) {
                    max = Math.max(max, calculate(grid, currRow + 1, aC, bC));
                }
            }
        }

        result += max; //add maximum result
        return result;
    }
}
