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
    int answer = -1;
    int rowLen = 0;
    int colLen = 0;

    public int cherryPickup(final int[][] grid) {
        rowLen = grid.length;
        colLen = grid[0].length;

        //소프티어처럼 1번 끝나면, 2번이 출발한다.
        //모든 경우의 수를 고려해서 최대 값을 구한다.
        final int collect = 0;
        final int robotNum = 1;
        calculate(grid, collect, robotNum, 0, 0);

        return answer;
    }

    private void calculate(final int[][] grid, final int collect, final int robotNum, final int r, final int c) {
        //2번까지 모두 끝남 -> 최대 값 비교
        if (robotNum == 2 && r == rowLen) {
            answer = Math.max(answer, collect);
            return;
        }

        //1번이 끝남 -> 2번 시작
        if (robotNum == 1 && r == rowLen) {
            calculate(grid, collect, 2, 0, colLen - 1);
            return;
        }

        //현재 자리에서 체리 수집
        final int cherry = grid[r][c];
        grid[r][c] = 0;

        //왼쪽
        final int leftC = c - 1;
        if (0 <= leftC && leftC < colLen) {
            calculate(grid, collect + cherry, robotNum, r + 1, leftC);
        }

        //아래
        final int downC = c;
        if (0 <= downC && downC < colLen) {
            calculate(grid, collect + cherry, robotNum, r + 1, downC);
        }

        //오른쪽
        final int rightC = c + 1;
        if (0 <= rightC && rightC < colLen) {
            calculate(grid, collect + cherry, robotNum, r + 1, rightC);
        }

        grid[r][c] = cherry;
    }
}
