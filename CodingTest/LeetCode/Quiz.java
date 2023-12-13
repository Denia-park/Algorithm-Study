package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numSpecial(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,0,0],[0,0,1],[1,0,0]]")));
        System.out.println(solution.numSpecial(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1,0,0],[0,1,0],[0,0,1]]")));
    }
}

class Solution {
    public int numSpecial(final int[][] mat) {
        int answer = 0;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }

                boolean check = true;
                //행 체크
                for (int i = 0; i < mat[0].length; i++) {
                    final int val = mat[row][i];

                    if (val == 1 && i != col) {
                        check = false;
                        break;
                    }
                }

                if (!check) {
                    continue;
                }

                //열 체크
                for (int i = 0; i < mat.length; i++) {
                    final int val = mat[i][col];

                    if (val == 1 && i != row) {
                        check = false;
                        break;
                    }
                }
                if (!check) {
                    continue;
                }

                answer++;
            }
        }

        return answer;
    }
}
