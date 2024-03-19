package CodingTest.LeetCode;

import java.util.*;

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
    }
}

class Solution {
    public int leastInterval(final char[] tasks, final int n) {
        int taskIdx = 0;

        //어떤 순서든 상관 없음 -> 그러나 cooling time을 가져야 함
        final Set<Character> set = new HashSet<>();
        final Map<Character, Integer> taskCountMap = new HashMap<>();
        final Map<Character, Integer> taskLastIdx = new HashMap<>();

        for (final char task : tasks) {
            set.add(task);
            taskCountMap.put(task, taskCountMap.getOrDefault(task, 0) + 1);
            taskLastIdx.put(task, -1);
        }

        final Deque<Character> dq = new ArrayDeque<>(set);

        while (!dq.isEmpty()) {
            final char task = dq.pollFirst();

            //바로 업무 시작 가능
            final int lastIdx = taskLastIdx.get(task);
            if (lastIdx < 0) {
                //업무 업데이트
                taskLastIdx.put(task, taskIdx);
                //Count에서 -1 처리
                int taskCount = taskCountMap.get(task);
                if (taskCount == 1) { //업무 끝남 삭제
                    taskCountMap.remove(task);
                } else {
                    taskCount -= 1;
                    taskCountMap.put(task, taskCount);
                    dq.addLast(task);
                }
            } else {
                //현재 작업 가능
                if (taskIdx - lastIdx > n) {
                    //업무 업데이트
                    taskLastIdx.put(task, taskIdx);

                    //Count에서 -1 처리
                    int taskCount = taskCountMap.get(task);
                    if (taskCount == 1) { //업무 끝남 삭제
                        taskCountMap.remove(task);
                    } else {
                        taskCount -= 1;
                        taskCountMap.put(task, taskCount);
                        dq.addLast(task);
                    }
                } else {
                    //마지막에 진행한 업무랑 현재 업무 사이에 cooling time을 가져야 함
                    //IDLE 작업
                    dq.addFirst(task);
                }
            }

            taskIdx++;
        }

        return taskIdx;
    }
}
