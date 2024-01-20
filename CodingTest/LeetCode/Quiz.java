package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.sumSubarrayMins(
                new int[]{3, 1, 2, 4}
        ));
        System.out.println("2 : " + solution.sumSubarrayMins(
                new int[]{11, 81, 94, 43, 3}
        ));
    }
}

class Solution {
    static final int MOD = (int) (Math.pow(10, 9) + 7);

    public int sumSubarrayMins(final int[] arr) {
        final int len = arr.length;

        final Deque<Integer> deque = new ArrayDeque<>();
        long sum = 0;

        for (int idx = 0; idx <= len; idx++) {
            //모든 idx를 다 돈 경우, 최소 값이 바뀌는 경우
            while (!deque.isEmpty() && (idx == len || arr[deque.peek()] >= arr[idx])) {
                //deque의 top 값에 대해서 계산을 한다.
                final int mid = deque.poll();

                //현재 최소 값으로 몇 개의 subArray가 만들어 졌는지 개수 체크
                final int leftBoundary = deque.isEmpty() ? -1 : deque.peek();
                final int rightBoundary = idx;

                final long count = (long) (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                //개수 * 최소 값
                sum = (sum + (count * arr[mid]) % MOD) % MOD;
            }

            deque.push(idx);
        }

        return (int) sum;
    }
}
