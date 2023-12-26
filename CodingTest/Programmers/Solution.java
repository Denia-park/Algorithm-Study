package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<int[]> answer;

    public int[][] solution(final int totalNum) {
        answer = new ArrayList<>();

        hanoi(totalNum, 1, 2, 3);

        return answer.toArray(int[][]::new);
    }

    private void hanoi(final int totalNum, final int from, final int by, final int to) {
        if (totalNum == 1) {
            answer.add(new int[]{from, to});
            return;
        }

        //totalNum - 1개를 from에서 by로 옮긴다.
        hanoi(totalNum - 1, from, to, by);

        //1개를 from에서 to로 옮긴다.
        hanoi(1, from, by, to);

        //totalNum - 1개를 by에서 to로 옮긴다.
        hanoi(totalNum - 1, by, from, to);
    }
}
