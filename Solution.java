import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int curTime = 0;

        PriorityQueue<Task> readyQueue = new PriorityQueue<>();
        PriorityQueue<Task> waitingQueue = new PriorityQueue<>((a, b) -> a.taskTime - b.taskTime);
        List<Task> quitTaskList = new ArrayList<Task>();

        for (int[] job : jobs) {
            readyQueue.offer(new Task(job[0], job[1]));
        }

        while (quitTaskList.size() != jobs.length) {
            if (!readyQueue.isEmpty()) {
                Task readyTask = readyQueue.peek();

                if (readyTask.startTime <= curTime) {
                    Task tempTask = readyQueue.poll();
                    waitingQueue.offer(tempTask);
                }
            }

            if (!waitingQueue.isEmpty()) {
                Task runTask = waitingQueue.peek();
                if (!runTask.taskStartFlag) {
                    runTask.taskStartFlag = true;
                    runTask.taskStartTime = curTime;
                }

                if (curTime >= runTask.taskStartTime + runTask.taskTime) {
                    Task quitTask = waitingQueue.poll();
                    quitTask.endTime = curTime;
                    quitTaskList.add(quitTask);

                    if (!waitingQueue.isEmpty()) {
                        Task nextTask = waitingQueue.peek();
                        if (!nextTask.taskStartFlag) {
                            nextTask.taskStartFlag = true;
                            nextTask.taskStartTime = curTime;
                        }
                    }
                }
            }
            curTime++;
        }

        int sum = 0;
        for (Task task : quitTaskList) {
            sum += task.getCompleteTime();
        }

        return sum / quitTaskList.size();
    }
}

class Task implements Comparable<Task> {
    int startTime;
    int endTime;
    int taskStartTime;
    boolean taskStartFlag;
    int taskTime;

    public Task(int startTime, int taskTime) {
        this.startTime = startTime;
        this.taskTime = taskTime;
        taskStartTime = 0;
        taskStartFlag = false;
    }

    public int getCompleteTime() {
        return endTime - startTime;
    }

    @Override
    public int compareTo(Task o) {
        if (this.startTime < o.startTime) {
            return -1;
        } else if (this.startTime == o.startTime) {
            return this.taskTime - o.taskTime;
        } else {
            return 1;
        }
    }
}
