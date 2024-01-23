package CodingTest.Programmers;

/*
아이디어
- 그리디 (정렬해서 처리하기)

시간 복잡도
- n * log n

자료 구조
- List 정렬을 사용 (Comparator)
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

class Solution {
    public int solution(final int[][] jobs) {
        final List<Disk> disks = new ArrayList<>();
        //jobs를 Disk List로 변경
        for (final int[] job : jobs) {
            disks.add(new Disk(job[0], job[0] + job[1]));
        }

        disks.sort(Comparator.comparingInt(Disk::getEnd));

        int curTime = 0;
        for (final Disk disk : disks) {
            curTime += disk.getProcessTime();

            disk.setComplete(curTime);
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
