package CodingTest.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                        2
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'C', 'A', 'B', 'D', 'B'},
                        2
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                        3
                )
        );
        System.out.println(
                solution.leastInterval(
                        new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        1
                )
        );
    }
}

class Solution {
    public int leastInterval(final char[] tasks, final int n) {
        int curTaskIdx = 0;

        final Map<Character, Task> taskMap = new HashMap<>();

        for (final char task : tasks) {
            taskMap.computeIfAbsent(task, Task::new).count++;
        }

        final PriorityQueue<Task> workQue = new PriorityQueue<>(
                Comparator.comparingInt(t -> t.count * -1)
        );
        final PriorityQueue<Task> waitQue = new PriorityQueue<>(
                Comparator.comparingInt(t -> t.lastIdx)
        );

        workQue.addAll(taskMap.values());

        while (!workQue.isEmpty() || !waitQue.isEmpty()) {
            //waitQue 확인하고, 작업 처리가 가능한 애들을 workQue에 넣자
            while (!waitQue.isEmpty() && (curTaskIdx - waitQue.peek().lastIdx > n)) {
                workQue.add(waitQue.poll());
            }

            //가능한 작업이 없음
            if (workQue.isEmpty()) {
                //IDLE 작업
                curTaskIdx++;
                continue;
            }

            final Task curTask = workQue.poll();

            //바로 업무 처리 가능
            proceedWork(curTask, curTaskIdx, waitQue);
            curTaskIdx++;
        }

        return curTaskIdx;
    }

    private void proceedWork(final Task curTask, final int curTaskIdx, final PriorityQueue<Task> waitQue) {
        curTask.lastIdx = curTaskIdx;

        //업무 진행, 남은 업무가 없으면 waitQue에 추가하지 않음
        if (curTask.count > 1) {
            curTask.count--;

            //업무 남아 있음
            waitQue.add(curTask);
        }
    }

    static class Task {
        int lastIdx;
        char ch;
        int count = 0;

        public Task(final char ch) {
            this.ch = ch;
            this.lastIdx = -1;
        }
    }
}
