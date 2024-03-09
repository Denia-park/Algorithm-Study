package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int[] stations, final int w) {
        int answer = 0;

        int start = 1;
        int end;
        final int width = 2 * w + 1;

        for (final int station : stations) {
            final int tempS = station - w;
            final int tempE = station + w;

            end = tempS;

            answer += (int) Math.ceil((float) (end - start) / width);

            start = tempE + 1;
        }

        if (start < n) {
            end = n + 1;
            answer += (int) Math.ceil((float) (end - start) / width);
        }

        return answer;
    }
}
