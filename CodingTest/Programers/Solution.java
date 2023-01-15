package CodingTest.Programers;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int scoreMax, int appleNum, int[] scores) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : scores) {
            pq.offer(j);
        }

        while (pq.size() >= appleNum) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < appleNum; i++) {
                min = pq.poll();
            }
            answer += (min * appleNum);
        }

        return answer;
    }
}
