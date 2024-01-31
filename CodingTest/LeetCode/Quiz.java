package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{30, 60, 90})));
    }
}

class Solution {
    public int[] dailyTemperatures(final int[] temperatures) {
        final int length = temperatures.length;
        final int[] answer = new int[length];

        final Deque<int[]> dq = new ArrayDeque<>();
        for (int idx = 0; idx < length; idx++) {
            final int temp = temperatures[idx];

            //비어있지 않으면 현재 기온과 비교한다.
            //Stack을 뒤지면서 다 처리해야 한다.
            while (!dq.isEmpty()) {
                //지금이 더 따뜻하면, 기존 값을 빼고 answer에 값을 추가한다.
                final int[] curTemp = dq.peek();

                if (curTemp[1] >= temp) break;

                dq.poll();
                answer[curTemp[0]] = idx - curTemp[0];
            }

            dq.push(new int[]{idx, temp});
        }

        return answer;
    }
}
