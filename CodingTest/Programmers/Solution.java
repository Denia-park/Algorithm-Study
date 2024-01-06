package CodingTest.Programmers;

class Solution {
    public int solution(final int[][] dots) {
        int answer = 0;

        //0,1 / 2,3
        double a = getLeanDegree(dots[0], dots[1]);
        double b = getLeanDegree(dots[2], dots[3]);

        if (a == b) {
            answer = 1;
        }

        //0,2 / 1,3
        a = getLeanDegree(dots[0], dots[2]);
        b = getLeanDegree(dots[1], dots[3]);

        if (a == b) {
            answer = 1;
        }

        //0,3 / 1,2
        a = getLeanDegree(dots[0], dots[3]);
        b = getLeanDegree(dots[1], dots[2]);

        if (a == b) {
            answer = 1;
        }

        return answer;
    }

    private double getLeanDegree(final int[] point1, final int[] point2) {
        return (double) (point1[1] - point2[1]) / (point1[0] - point2[0]);
    }
}
