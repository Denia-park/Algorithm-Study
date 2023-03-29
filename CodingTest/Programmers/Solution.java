package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int start, int target, int plus) {
        //bfs 풀이
        Deque<int[]> deque = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        deque.add(new int[]{start, 0}); // 시작값, count

        while (!deque.isEmpty()) {
            int[] curValArr = deque.pollFirst();
            int curVal = curValArr[0];
            int curCount = curValArr[1];
            if (curVal == target) {
                return curCount;
            }

            //curVal에 n 더하기
            validateNextValue(target, deque, visited, curCount, curVal + plus);

            //curval에 2 곱하기
            validateNextValue(target, deque, visited, curCount, curVal * 2);

            //curval에 3 곱하기
            validateNextValue(target, deque, visited, curCount, curVal * 3);
        }

        return -1;
    }

    private void validateNextValue(int target, Deque<int[]> deque, Set<Integer> visited, int curCount, int nextValue) {
        if (!visited.contains(nextValue) && nextValue <= target) {
            deque.add(new int[]{nextValue, curCount + 1});
            visited.add(nextValue);
        }
    }
}
