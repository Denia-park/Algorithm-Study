package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.HashMap;
import java.util.Map;

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
        if (n == 1) {
            return 1;
        }

        //입력이 n -1개 이면서 출력이 0개
        final Map<Integer, Man> map = new HashMap<>();

        for (final int[] ints : trust) {
            final int from = ints[0];
            final int to = ints[1];

            final Man fMan = map.computeIfAbsent(from, Man::new);
            fMan.out++;

            final Man tMan = map.computeIfAbsent(to, Man::new);
            tMan.in++;
        }

        return map.values().stream()
                .filter(man -> man.in == n - 1 && man.out == 0)
                .mapToInt(man -> man.idx)
                .findFirst().orElse(-1);
    }

    public class Man {
        int idx;
        int in;
        int out;

        Man(final int idx) {
            this.idx = idx;
        }
    }
}
