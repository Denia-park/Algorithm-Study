package CodingTest.Programmers;

//아이디어 -> 우선 순위 큐 사용해야 함 (waititng Queue)
//작업 하던 와중에 들어오는 작업이 있으면 우선순위에 맞춰서 순서 재조정
//작업이 없는 상황이면 먼저 들어온 작업부터 처리함

//시간복잡도
//n * logN

//자료 구조
//우선순위 큐

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(final int[][] jobs) {
        final List<Task> tasks = new ArrayList<>();
        //jobs -> Tasks
        for (final int[] job : jobs) {
            tasks.add(new Task(job[0], job[1]));
        }
        //시작 시간에 맞춰서 오름차순 정렬
        tasks.sort(Comparator.comparingInt((Task task) -> task.startTime));

        //작업이 빨리 끝나는 애들부터 처리하는 우선순위 큐
        final PriorityQueue<Task> waitQue = new PriorityQueue<>(
                Comparator.comparingInt((Task task) -> task.processTime)
        );

        //현재 시간
        int curTime = 0;
        int jobIdx = 0;
        int completeJobCount = 0;

        final int totalJob = jobs.length;
        while (completeJobCount < totalJob) {

            //현재 시간에 입력 된 task를 확인 후 Queue에 넣는다.
            while (jobIdx < totalJob && tasks.get(jobIdx).startTime <= curTime) {
                waitQue.add(tasks.get(jobIdx));
                jobIdx++;
            }

            //작업 처리를 시작
            //시간이 안맞아서 아직 처리해야 하는 Task가 없으면, 첫번째 작업 시간으로 이동한다.
            if (waitQue.isEmpty()) {
                curTime = tasks.get(jobIdx).startTime;
            } else {
                //처리해야 하는 작업이 있으면 처리
                final Task playTask = waitQue.poll();

                curTime += playTask.processTime;
                playTask.endTime = curTime;

                //작업이 완료되었으므로, 완료 작업 수를 1 늘려준다.
                completeJobCount++;
            }
        }

        return (int) tasks.stream()
                .mapToInt((Task task) -> task.endTime - task.startTime)
                .average().getAsDouble();
    }
}

class Task {
    int startTime;
    int processTime;
    int endTime;

    public Task(final int startTime, final int processTime) {
        this.startTime = startTime;
        this.processTime = processTime;
    }
}
