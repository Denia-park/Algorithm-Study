package CodingTest.Programmers;

//연속된 부분 수열의 합 -> 연속된 ? 투포인터 써도 되나.

//input은 오름차순

import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<SubArray> pq = new PriorityQueue<>();
        int start = 0;
        int end = 0;
        int sum = 0;
        sum = sequence[0];

        while (start <= end) {
            if (sum == k) {
                pq.add(new SubArray(start, end));
                if (end >= (sequence.length - 1)) {
                    break;
                }
                end++;
                sum += sequence[end];
                start++;
                sum -= sequence[start - 1];
            } else if (sum < k) {
                if (end >= (sequence.length - 1)) {
                    break;
                }
                end++;
                sum += sequence[end];
            } else {
                start++;
                sum -= sequence[start - 1];
            }
        }

        return pq.peek().toArray();
    }

    class SubArray implements Comparable<SubArray> {
        int startIdx;
        int endIdx;

        public SubArray(int startIdx, int endIdx) {
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }

        @Override
        public int compareTo(SubArray o) {
            //짧은 수열 우선
            int originDiff = (this.endIdx - this.startIdx);
            int otherDiff = (o.endIdx - o.startIdx);
            if (originDiff == otherDiff) {
                //앞쪽 인덱스가 작은 수열 우선
                return this.startIdx - o.startIdx;
            }
            return originDiff - otherDiff;
        }

        public int[] toArray() {
            return new int[]{this.startIdx, this.endIdx};
        }
    }
}
