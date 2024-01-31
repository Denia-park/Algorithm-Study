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
        final int[] answer = new int[temperatures.length];

        final Deque<Temp> dq = new ArrayDeque<>();
        for (int idx = 0; idx < temperatures.length; idx++) {
            final int temp = temperatures[idx];

            //비어있으면 추가한다.
            if (dq.isEmpty()) {
                dq.push(new Temp(idx, temp));
                continue;
            }

            //비어있지 않으면 현재 기온과 비교한다.
            //Stack을 뒤지면서 다 처리해야 한다.
            while (!dq.isEmpty()) {
                //지금이 더 따뜻하면, 기존 값을 빼고 answer에 값을 추가한다.
                final Temp curTemp = dq.peek();

                if (curTemp.value >= temp) break;

                dq.poll();
                answer[curTemp.idx] = idx - curTemp.idx;
            }

            dq.push(new Temp(idx, temp));
        }

        return answer;
    }

    static class Temp {
        int idx;
        int value;

        public Temp(final int idx, final int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
