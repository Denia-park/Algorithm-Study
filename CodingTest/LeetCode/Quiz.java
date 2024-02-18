package CodingTest.LeetCode;

import CodingTest.Programmers.BracketUtil;

import java.util.Arrays;
import java.util.Comparator;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.mostBooked(
                        2,
                        BracketUtil.convertStrToIntArr(
                                "[[0,10],[1,5],[2,7],[3,4]]"
                        )
                )
        );
        System.out.println(
                solution.mostBooked(
                        3,
                        BracketUtil.convertStrToIntArr(
                                "[[1,20],[2,10],[3,5],[4,9],[6,8]]"
                        )
                )
        );
    }
}

class Solution {
    public int mostBooked(final int n, final int[][] meetings) {
        final int[] ans = new int[n];
        final long[] times = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        for (final int[] meeting : meetings) {
            final int start = meeting[0];
            final int end = meeting[1];

            boolean flag = false;
            int minIdx = -1;
            long val = Long.MAX_VALUE;

            //모든 방을 돌면서, 제일 빨리 끝나는 방을 찾는다.
            for (int idx = 0; idx < n; idx++) {
                //제일 빨리 끝나는 방 저장
                if (times[idx] < val) {
                    val = times[idx];
                    minIdx = idx;
                }

                //시작할 수 있는 방을 찾았으면 멈춘다.
                if (times[idx] <= start) {
                    flag = true;
                    ans[idx]++;
                    times[idx] = end;
                    break;
                }
            }

            //방을 못 찾았으면, 제일 빨리 끝나는 방에서 시작한다.
            if (!flag) {
                ans[minIdx]++;
                times[minIdx] += (end - start);
            }
        }

        //가장 많이 사용한 방을 찾는다.
        int max = -1;
        int resultIdx = -1;
        for (int i = 0; i < ans.length; i++) {
            final int val = ans[i];

            if (val > max) {
                max = val;
                resultIdx = i;
            }
        }

        return resultIdx;
    }
}
