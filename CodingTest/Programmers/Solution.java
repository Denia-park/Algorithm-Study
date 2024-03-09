package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int[] stations, final int w) {
        int answer = 0;

        int start = 1;
        int end;
        final double width = 2 * w + 1;

        for (final int station : stations) {
            end = (station - w);

            answer += (int) Math.ceil((end - start) / width);

            start = station + w + 1;
        }

        if (start <= n) {
            end = n + 1;
            answer += (int) Math.ceil((end - start) / width);
        }

        return answer;
    }
}
