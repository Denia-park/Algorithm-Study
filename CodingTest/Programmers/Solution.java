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
            final int start = job[0];
            final int process = job[1];

            disks.add(new Disk(start, start + process));
        }

        disks.sort(Comparator.comparingInt(Disk::getStart));

        final PriorityQueue<Disk> pq = new PriorityQueue<>(
                Comparator.comparingInt(Disk::getEnd)
        );

        int curTime = 0;

        for (final Disk disk : disks) {
            if (pq.isEmpty()) {
                curTime = disk.getStart();
                pq.add(disk);
                continue;
            }

            final Disk peek = pq.peek();
            final int end = peek.getEnd();
            final int start = disk.getStart();

            if (start <= (curTime + end)) {
                pq.add(disk);
                continue;
            }

            while (!pq.isEmpty()) {
                final Disk top = pq.poll();

                curTime += top.getProcessTime();
                top.setComplete(curTime);
            }

            //시작시간이 현재 시간보다 이후 인 경우, 시작 시간 변경
            curTime = start;
            pq.add(disk);
        }

        while (!pq.isEmpty()) {
            final Disk top = pq.poll();

            curTime += top.getProcessTime();
            top.setComplete(curTime);
        }

        for (final Disk disk : disks) {
            System.out.println(disk);
        }

        final OptionalDouble average = disks.stream()
                .mapToInt(disk -> disk.getComplete() - disk.getStart())
                .average();

        return (int) average.getAsDouble();
    }

    static class Disk {
        int start;
        int end;
        int complete;

        Disk(final int start, final int end) {
            this.start = start;
            this.end = end;
            this.complete = 0;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getProcessTime() {
            return end - start;
        }

        public int getComplete() {
            return complete;
        }

        public void setComplete(final int complete) {
            this.complete = complete;
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "start=" + start +
                    ", end=" + end +
                    ", complete=" + complete +
                    '}';
        }
    }
}
