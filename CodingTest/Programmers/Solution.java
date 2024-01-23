package CodingTest.Programmers;

/*
아이디어
- 그리디 (정렬해서 처리하기)

시간 복잡도
- n * log n

자료 구조
- List 정렬을 사용 (Comparator)
 */

import java.util.*;

class Solution {
    public int solution(final int[][] jobs) {
        final List<Disk> disks = new ArrayList<>();

        //jobs를 Disk List로 변경
        for (final int[] job : jobs) {
            disks.add(new Disk(job[0], job[1]));
        }

        disks.sort(Comparator.comparingInt(Disk::getStart).thenComparingInt(Disk::getProcess));

        final PriorityQueue<Disk> pq = new PriorityQueue<>(Comparator.comparingInt(Disk::getProcess));

        int curTime = 0;

        for (final Disk curDisk : disks) {
            final int curStart = curDisk.getStart();

            //현재 시간 보다 요청시간이 빠르면 다 추가
            if (curStart <= curTime) {
                pq.add(curDisk);
                continue;
            }

            if (pq.isEmpty()) {
                curTime = curStart;
                pq.add(curDisk);
                continue;
            }

            //현재 시간 보다 요청 시간이 느리면 우선 현재 큐에 있는 작업들을 처리
            //queue에 있는 작업을 처리
            while (!pq.isEmpty() && curTime < curStart) {
                final Disk topDisk = pq.poll();
                curTime += topDisk.getProcess();
                topDisk.setComplete(curTime);
            }

            if (curTime < curStart) {
                curTime = curStart;
            }

            pq.add(curDisk);
        }

        //남은 작업 처리
        while (!pq.isEmpty()) {
            final Disk topDisk = pq.poll();
            curTime += topDisk.getProcess();
            topDisk.setComplete(curTime);
        }

        final OptionalDouble average = disks.stream()
                .mapToInt(disk -> disk.getComplete() - disk.getStart())
                .average();

        return (int) average.getAsDouble();
    }

    static class Disk {
        int start;
        int process;
        int complete;

        Disk(final int start, final int process) {
            this.start = start;
            this.process = process;
            this.complete = 0;
        }

        public int getStart() {
            return start;
        }

        public int getProcess() {
            return process;
        }

        public int getComplete() {
            return complete;
        }

        public void setComplete(final int complete) {
            this.complete = complete;
        }
    }
}

/*
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//정답 참고
//https://codevang.tistory.com/316

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int curTime = 0;
        int jobsIdx = 0;
        int completeCount = 0;

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        while (completeCount < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= curTime) {
                waitingQueue.add(jobs[jobsIdx]);
                jobsIdx++;
            }

            if (waitingQueue.isEmpty()) {
                curTime = jobs[jobsIdx][0];
            } else {
                int[] job = waitingQueue.poll();
                answer += curTime + job[1] - job[0];
                curTime += job[1];
                completeCount++;
            }
        }

        return answer / jobs.length;
    }
}
 */
