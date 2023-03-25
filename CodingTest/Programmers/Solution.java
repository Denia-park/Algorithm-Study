package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int totalSectionNum, int rollerLength, int[] sectionsToPaint) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        for (int section : sectionsToPaint) {
            deque.add(section);
        }

        int firstSection = deque.pollFirst();
        int paintRollerLength = firstSection + rollerLength - 1;
        answer++;

        while (!deque.isEmpty()) {
            int nextSection = deque.pollFirst();

            if (nextSection > paintRollerLength) {
                paintRollerLength = nextSection + rollerLength - 1;
                answer++;
            }
        }

        return answer;
    }
}
