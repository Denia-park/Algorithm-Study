package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[0,1,0],[1,1,1],[0,1,0]]"),
                0));
        System.out.println("2 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,-1],[-1,1]]"),
                0));
        System.out.println("3 : " + solution.numSubmatrixSumTarget(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[904]]"),
                0));
    }
}

/*
아이디어 - DP
 */

class Solution {
    public int numSubmatrixSumTarget(final int[][] matrix, final int target) {
        int answer = 0;

        final int totalRow = matrix.length;
        final int totalCol = matrix[0].length;

        final int[][][] dp = new int[totalRow][totalCol][totalCol];

        for (int row = 0; row < totalRow; row++) {
            for (int startCol = 0; startCol < totalCol; startCol++) {
                for (int endCol = startCol; endCol < totalCol; endCol++) {
                    if (startCol == endCol) {
                        dp[row][startCol][endCol] = matrix[row][startCol];
                        continue;
                    }

                    dp[row][startCol][endCol] = (dp[row][startCol][endCol - 1] + matrix[row][endCol]);
                }
            }
        }

        //가로가 1, 세로가 1 인거부터 가로 1 세로 2 가로 1 세로 3, 등등 모든 조합을 구한다?
        for (int rowNum = 1; rowNum <= totalRow; rowNum++) {
            for (int colNum = 1; colNum <= totalCol; colNum++) {
                for (int startRow = 0; startRow <= totalRow - rowNum; startRow++) {
                    for (int startCol = 0; startCol <= totalCol - colNum; startCol++) {
                        int sum = 0;

                        for (int rowCount = 0; rowCount < rowNum; rowCount++) {
                            sum += dp[startRow + rowCount][startCol][startCol + colNum - 1];
                        }

                        if (sum == target) {
                            answer++;
                        }
                    }
                }
            }
        }


        return answer;
    }
}
