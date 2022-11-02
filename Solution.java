import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        List<Enemy> enemies = new ArrayList<Enemy>();

        for (int i = 0; i < scope.length; i++) {
            int[] distanceArr = scope[i];
            int[] timeArr = times[i];

            int workStartDistance = Math.min(distanceArr[0], distanceArr[1]);
            int workEndDistance = Math.max(distanceArr[0], distanceArr[1]);

            int workTime = timeArr[0];
            int restTime = timeArr[1];

            enemies.add(new Enemy(workStartDistance, workEndDistance, workTime, restTime));
        }

        enemies.sort(null);

        for (Enemy enemy : enemies) {
            for (int curTime = enemy.getWorkStartDistance(); curTime <= enemy.getWorkEndDistance(); curTime++) {
                if (isWorkingTime(curTime, enemy.getWorkTime(), enemy.getRestTime())) {
                    return curTime;
                }
            }
        }

        return distance;
    }

    private boolean isWorkingTime(int curTime, int workTime, int restTime) {
        int totalTime = workTime + restTime;
        int curStatus = curTime % totalTime;

        return 0 < curStatus && curStatus <= workTime;
    }
}

class Enemy implements Comparable<Enemy> {
    private final int workStartDistance;
    private final int workEndDistance;

    private final int workTime;
    private final int restTime;

    public Enemy(int workStartDistance, int workEndDistance, int workTime, int restTime) {
        this.workStartDistance = workStartDistance;
        this.workEndDistance = workEndDistance;
        this.workTime = workTime;
        this.restTime = restTime;
    }

    public int getWorkStartDistance() {
        return workStartDistance;
    }

    public int getWorkEndDistance() {
        return workEndDistance;
    }

    public int getWorkTime() {
        return workTime;
    }

    public int getRestTime() {
        return restTime;
    }

    @Override
    public int compareTo(Enemy another) {
        return this.workStartDistance - another.workStartDistance;
    }
}
