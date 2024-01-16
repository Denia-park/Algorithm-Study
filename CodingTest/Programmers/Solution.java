package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(final int[] progresses, final int[] speeds) {
        final List<Integer> answerList = new ArrayList<>();

        final int max = 100;
        int day = 0;

        int eachCount = 0;

        for (int i = 0; i < progresses.length; i++) {
            if (day * speeds[i] + progresses[i] >= max) {
                eachCount++;
                continue;
            }

            if (eachCount > 0) {
                answerList.add(eachCount);
            }

            eachCount = 0;

            final int progress = progresses[i];
            final int rest = max - progress;

            final int speed = speeds[i];

            final int progressDay = (int) Math.ceil(rest / speed);

            day += progressDay;

            eachCount++;
        }

        //남은거 처리
        answerList.add(eachCount);

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
