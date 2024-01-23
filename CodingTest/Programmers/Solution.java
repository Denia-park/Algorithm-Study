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
        int completeCount = 0;
        int jobsIdx = 0;

        final int totalLength = jobs.length;

        while (completeCount < totalLength) {
            while (jobsIdx < totalLength && disks.get(jobsIdx).getStart() <= curTime) {
                pq.add(disks.get(jobsIdx));
                jobsIdx++;
            }

            if (pq.isEmpty()) {
                curTime = disks.get(jobsIdx).getStart();
            } else {
                final Disk curDisk = pq.poll();
                curTime += curDisk.getProcess();
                curDisk.setComplete(curTime);
                completeCount++;
            }
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
