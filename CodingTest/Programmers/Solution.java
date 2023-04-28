package CodingTest.Programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while (idx < arr.length) {
            if (dq.isEmpty()) {
                dq.addLast(arr[idx]);
                idx++;
            } else {
                if (dq.peekLast() == arr[idx]) {
                    dq.pollLast();
                    idx++;
                } else {
                    dq.addLast(arr[idx]);
                    idx++;
                }
            }
        }
        if (dq.isEmpty()) {
            return new int[]{-1};
        }

        List<Integer> answers = new ArrayList<>(dq);

        return answers.stream().mapToInt(i -> i).toArray();
    }
}
