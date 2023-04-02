package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

// 23-04-02 16시 37분
// 47분 걸림
class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<int[]> collatz = getCollatz(k);

        int lastCount = collatz.get(collatz.size() - 1)[0];
        double[] result = new double[collatz.size() - 1];
        for (int i = 0; i < collatz.size() - 1; i++) {
            result[i] = getSize(collatz.get(i), collatz.get(i + 1));
        }

        int idx = 0;
        double[] answer = new double[ranges.length];
        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            double sum = 0;

            if (start == 0 && end == 0) {
                for (double v : result) {
                    sum += v;
                }
            } else {
                if (start > (lastCount + end)) {
                    sum = -1.0;
                } else {
                    for (int i = start; i < (lastCount + end); i++) {
                        sum += result[i];
                    }
                }
            }

            answer[idx] = sum;
            idx++;
        }

        return answer;
    }

    private double getSize(int[] ints, int[] ints1) {
        int lowH = Math.min(ints[1], ints1[1]);
        int highH = Math.max(ints[1], ints1[1]);

        int rectSize = lowH;
        double triSize = ((double) (highH - lowH) / 2);

        return rectSize + triSize;
    }

    private List<int[]> getCollatz(int k) {
        List<int[]> collatz = new ArrayList<>();

        int count = 0;
        collatz.add(new int[]{count++, k});

        while (k != 1) {
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = (k * 3) + 1;
            }
            collatz.add(new int[]{count++, k});
        }

        return collatz;
    }
}
