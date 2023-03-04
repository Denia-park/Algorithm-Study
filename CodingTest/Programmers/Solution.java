package CodingTest.Programmers;

class Solution {

    public long solution(int balls, int share) {
        long answer = 0;

        answer = factorial(balls) / (factorial(balls - share)) * factorial(share);

        return answer;
    }

    private long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
