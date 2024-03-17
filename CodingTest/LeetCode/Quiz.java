package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((Arrays.deepToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}))));
        System.out.println((Arrays.deepToString(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}))));
    }
}

class Solution {
    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        final List<int[]> ints = new ArrayList<>();

        Collections.addAll(ints, intervals);
        ints.add(newInterval);

        ints.sort(Comparator.comparingInt(arr -> arr[0]));

        final Deque<int[]> answer = new ArrayDeque<>();
        for (final int[] interval : ints) {
            //마지막에 등록된 인터벌의 종료시간보다 현재 인터벌의 시작시간이 빠르면 합쳐준다.
            if (!answer.isEmpty() && answer.peekLast()[1] >= interval[0]) {
                final int[] last = answer.pollLast();

                answer.addLast(new int[]{Math.min(last[0], interval[0]), Math.max(last[1], interval[1])});
                continue;
            }

            answer.add(interval);
        }

        return answer.toArray(int[][]::new);
    }
}
