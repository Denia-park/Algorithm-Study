package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);
            } else {
                return -1 * Integer.compare(a[0], b[0]);
            }
        });

        List<Integer> xorList = new ArrayList<>();
        for (int i = rowBegin - 1; i <= rowEnd - 1; i++) {
            int[] tempArr = data[i];
            int sum = 0;
            int originIdx = i + 1;

            for (int k : tempArr) {
                sum += (k % originIdx);
            }

            xorList.add(sum);
        }

        return xorList.stream().reduce((a, b) -> a ^ b).orElse(0);
    }
}
