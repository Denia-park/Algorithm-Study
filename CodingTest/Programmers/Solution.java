package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MAX = 100;

    public int[] solution(final int[] progresses, final int[] speeds) {
        final List<Integer> answerList = new ArrayList<>();

        int day = 0;

        int completeCount = 0;

        for (int i = 0; i < progresses.length; i++) {
            final int curProgress = progresses[i];
            final int curSpeed = speeds[i];

            final int curTotalProgress = (day * curSpeed) + curProgress;

            if (isComplete(curTotalProgress)) {
                completeCount++;
                continue;
            }

            if (completeCount > 0) {
                answerList.add(completeCount);
                completeCount = 0;
            }

            final int restProgress = MAX - curTotalProgress;
            final int progressDay = (int) Math.ceil(restProgress / curSpeed);

            day += progressDay;

            completeCount++;
        }

        //남은거 처리
        answerList.add(completeCount);

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private boolean isComplete(final int curTotalProgress) {
        return curTotalProgress >= MAX;
    }
}
