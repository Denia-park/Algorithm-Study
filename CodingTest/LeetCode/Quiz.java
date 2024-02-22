package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findJudge(2,
                BracketUtil.convertStrToIntArr(
                        "[[1, 2]]"
                )));
        System.out.println(solution.findJudge(3,
                BracketUtil.convertStrToIntArr(
                        "[[1, 3], [2, 3]]"
                )));
        System.out.println(solution.findJudge(3,
                BracketUtil.convertStrToIntArr(
                        "[[1, 3], [2, 3], [3, 1]]"
                )));
    }
}

class Solution {
    public int findJudge(final int n, final int[][] trust) {
        final int[] trusting = new int[n + 1];
        final int[] trusted = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            trusting[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }

        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (trusting[i] == 0 && trusted[i] == n - 1)
                ans = i;
        }

        return ans;
    }
}
