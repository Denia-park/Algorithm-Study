package CodingTest.Programmers;

class Solution {
    public int solution(final int[][] dots) {
        int answer = 0;

        //0,1 / 2,3
        double a = (double) (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);
        double b = (double) (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);

        if (a == b) {
            answer = 1;
        }

        //0,2 / 1,3
        a = (double) (dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);
        b = (double) (dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);

        if (a == b) {
            answer = 1;
        }

        //0,3 / 1,2
        a = (double) (dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);
        b = (double) (dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);

        if (a == b) {
            answer = 1;
        }

        return answer;
    }
}
