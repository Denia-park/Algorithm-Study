package com.company;

import java.util.PriorityQueue;

public class Solution {
    static public void main(String[] args) {
//        int[] scoville1 = { 1, 2, 3, 9, 10, 12 };
        int[] scoville1 = { 1,1,1};
        int[] scoville2 = { 3, 3, 3, 9, 10, 12 };
        int K = 3;

        System.out.println(solution(scoville1, K));
        System.out.println(solution(scoville2, K));
    }

    static public int solution(int[] scoville, int K) {
        int answer = 0;

        //PriorityQueue 생성 : minValue를 제일 위로 보낸다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int sco : scoville) {
            pq.add(sco);
        }

        while ( pq.size() > 1 ) {
            if(pq.peek() >= K)
                return answer;

            int scoville0 = pq.poll();
            int scoville1 = pq.poll();

            int newScoville = scoville0 + scoville1 * 2;

            pq.add(newScoville);

            answer++;
        }

        if(pq.peek() >= K)
            return answer;

        return -1;
    }
}
