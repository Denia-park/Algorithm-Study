package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.minFallingPathSum(
                new int[][]{
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}
                }
        ));
        System.out.println("2 : " + solution.minFallingPathSum(
                new int[][]{
                        {-19, 57},
                        {-40, -5}
                }
        ));
    }
}

class Solution {
    public int minFallingPathSum(final int[][] matrix) {
        final int len = matrix.length;

        final int[][] dp = new int[len][len];

        System.arraycopy(matrix[0], 0, dp[0], 0, len);

        for (int row = 1; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int selectValue = Integer.MAX_VALUE;
                //왼쪽 대각선 위
                if (col != 0) {
                    selectValue = dp[row - 1][col - 1];
                }

                //바로 위
                selectValue = Math.min(selectValue, dp[row - 1][col]);

                //오른쪽 대각선 위
                if (col != (len - 1)) {
                    selectValue = Math.min(selectValue, dp[row - 1][col + 1]);
                }

                dp[row][col] = matrix[row][col] + selectValue;
            }
        }

        //최소 값을 찾는다.
        return Arrays.stream(dp[len - 1]).min().getAsInt();
    }
}
