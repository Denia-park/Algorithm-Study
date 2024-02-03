package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final int n, final int[] lost, final int[] reserve) {
        final int[] students = new int[n + 2];
        Arrays.fill(students, 1);

        students[0] = 0;
        students[n + 1] = 0;

        for (final int l : lost) {
            students[l]--;
        }

        for (final int l : reserve) {
            students[l]++;
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

        return (int) Arrays.stream(students).filter(i -> i > 0).count();
    }
}
