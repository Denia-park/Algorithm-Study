import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        int index = 0;

        for (int sco : score) {
            pq.add(sco);

            if (pq.size() > k) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                answer[index] = pq.peek();
                index++;
            }
        }

        return answer;
    }
}
