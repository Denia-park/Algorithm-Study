package CodingTest.Programmers;

class Solution {
    private int getDividers(int num) {
        if (num == 1) return 1;

        int rootVal = (int) Math.sqrt(num);
        int count = 0;

        for (int i = 1; i <= rootVal; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        int answer = (count * 2);

        if (Math.pow(rootVal, 2) == num) {
            answer--;
        }

        return answer;
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int dividers = getDividers(i);

            if (dividers > limit) {
                dividers = power;
            }

            answer += dividers;

        }

        return answer;
    }
}
