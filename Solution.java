import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;
        Map<Integer, Boolean> workStatusMap = new HashMap<Integer, Boolean>();

        int scopeIndex = 0;

        out:
        for (int[] eachScope : scope) {
            int startTime = Math.min(eachScope[0], eachScope[1]);
            int endTime = Math.max(eachScope[0], eachScope[1]);
            for (int curTime = startTime; curTime <= endTime; curTime++) {
                if (isWorkingTime(curTime, times[scopeIndex])) {
                    break out;
                }
            }

            scopeIndex++;
        }

        return Math.min(answer, distance);
    }

    private boolean isWorkingTime(int curTime, int[] time) {
        int workTime = time[0];
        int restTime = time[1];

        int totalTime = workTime + restTime;

        curTime

    }
}
