package CodingTest.Programmers;

class Solution {
    int D;

    public long solution(int k, int d) {
        int divide = (d / k) + 1;
        long answer = (long) divide * divide;
        D = d;

        for (int y = d; y >= 0; y -= k) {
            for (int x = (d - y); x <= d; x += k) {
                if (isOutside(x, y)) {
                    answer--;
                    System.out.println(x + " " + y);
                }
            }
        }

        return answer;
    }

    private boolean isOutside(int x, int y) {
        return ((long) x * x) + ((long) y * y) > ((long) D * D);
    }
}
