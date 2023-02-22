package CodingTest.Programmers;

class Solution {
    int D;

    public long solution(int k, int d) {
        long answer = 0;
        D = d;

        for (int x = 0; x <= d; x += k) {
            for (int y = 0; y <= d; y += k) {
                if (isInside(x, y)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isInside(int x, int y) {
        return ((long) x * x) + ((long) y * y) <= ((long) D * D);
    }
}
