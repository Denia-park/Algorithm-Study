package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int[] stations, final int w) {
        int answer = 0;

        int start = 1;
        int end;
        final int width = 2 * w + 1;

        for (final int station : stations) {
            end = (station - w);

            answer += ceil((end - start), width);

            start = station + w + 1;
        }

        if (start <= n) {
            end = n + 1;
            answer += ceil((end - start), width);
        }

        return answer;
    }

    int ceil(final int val, final int div) {
        if (val <= 0) {
            return 0;
        }

        if (val % div == 0) {
            return val / div;
        } else {
            return val / div + 1;
        }
    }
}
