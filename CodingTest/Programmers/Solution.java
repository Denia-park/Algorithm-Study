package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] data, int input_col, int input_row_begin, int input_row_end) {
        int col = input_col - 1;
        int row_begin = input_row_begin - 1;
        int row_end = input_row_end - 1;

        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, data);

        list.sort((a, b) -> {
            if (a[col] != b[col]) {
                return Integer.compare(a[col], b[col]);
            } else {
                return -1 * Integer.compare(a[0], b[0]);
            }
        });

        List<Integer> xorList = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int[] tempArr = list.get(i);
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
