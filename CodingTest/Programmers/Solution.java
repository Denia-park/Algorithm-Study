package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final int n, final int[] lost, final int[] reserve) {
        int answer = 0;

        final int[] students = new int[n];
        Arrays.fill(students, 1);

        for (final int l : lost) {
            students[l - 1]--;
        }

        for (final int l : reserve) {
            students[l - 1]++;
        }

        //0번에 대해서 구하기
        if (students[0] == 0 && students[1] == 2) {
            students[1]--;
            students[0]++;
        }

        for (int i = 1; i < students.length - 1; i++) {
            final int curVal = students[i];

            if (curVal != 0) continue;

            final int preVal = students[i - 1];
            final int postVal = students[i + 1];
            if (preVal == 2) {
                students[i - 1]--;
                students[i]++;
            } else if (postVal == 2) {
                students[i + 1]--;
                students[i]++;
            }
        }

        //끝번에 대해서 구하기
        if (students[students.length - 1] == 0 && students[students.length - 2] == 2) {
            students[students.length - 2]--;
            students[students.length - 1]++;
        }

        for (int i = 0; i < students.length; i++) {
            final int curVal = students[i];

            if (curVal > 0) {
                answer++;
            }
        }

        return answer;
    }
}
