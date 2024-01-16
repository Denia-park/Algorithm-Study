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

            final double restProgress = (double) MAX - curTotalProgress;
            final int progressDay = (int) Math.ceil(restProgress / curSpeed);

            day += progressDay;

            completeCount++;
        }

        //남은거 처리
        answerList.add(completeCount);

        //int 배열로 변환
        final int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private boolean isComplete(final int curTotalProgress) {
        return curTotalProgress >= MAX;
    }
}
