package CodingTest.Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(final int col, final int row, final int[][] puddles) {
        final int[][] dp = new int[row + 1][col + 1];
        dp[1][1] = 1;

        final Set<String> checkSet = new HashSet<>();
        checkSet.add("1,1");
        for (final int[] puddle : puddles) {
            final int puddleCol = puddle[0];
            final int puddleRow = puddle[1];

            checkSet.add(puddleCol + "," + puddleRow);
        }

        for (int rowIdx = 1; rowIdx < row + 1; rowIdx++) {
            for (int colIdx = 1; colIdx < col + 1; colIdx++) {
                if (checkSet.contains(colIdx + "," + rowIdx)) {
                    continue;
                }

                dp[rowIdx][colIdx] = dp[rowIdx - 1][colIdx] + dp[rowIdx][colIdx - 1];
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[row][col];
    }
}
