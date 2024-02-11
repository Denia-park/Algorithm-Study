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
    int rowLen = 0;
    int colLen = 0;

    public int cherryPickup(final int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;

        //소프티어처럼 1번 끝나면, 2번이 출발한다.
        //모든 경우의 수를 고려해서 최대 값을 구한다.
        return calculate(grid, 0, 1, 0, 0);
    }

    private int calculate(final int[][] grid, final int collect, final int robotNum, final int r, final int c) {
        //1번이 끝남 -> 2번 시작
        if (robotNum == 1 && r == rowLen) {
            return collect + calculate(grid, 0, 2, 0, colLen - 1);
        } else if (robotNum == 2 && r == rowLen) {
            return 0;
        }

        int max = 0;

        //현재 자리에서 체리 수집
        final int cherry = grid[r][c];
        grid[r][c] = 0;

        //왼쪽
        final int leftC = c - 1;
        if (0 <= leftC && leftC < colLen) {
            final int temp = cherry + calculate(grid, collect, robotNum, r + 1, leftC);
            max = Math.max(max, temp);
        }

        //아래
        final int downC = c;
        if (0 <= downC && downC < colLen) {
            final int temp = cherry + calculate(grid, collect, robotNum, r + 1, downC);
            max = Math.max(max, temp);
        }

        //오른쪽
        final int rightC = c + 1;
        if (0 <= rightC && rightC < colLen) {
            final int temp = cherry + calculate(grid, collect, robotNum, r + 1, rightC);
            max = Math.max(max, temp);
        }

        grid[r][c] = cherry;

        return max;
    }
}
