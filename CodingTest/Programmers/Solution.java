package CodingTest.Programmers;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        for (int one = 0; one < weights.length; one++) {
            for (int two = one + 1; two < weights.length; two++) {
                if (weights[one] == weights[two]) {
                    answer++;
                } else if (weights[one] * 2 == weights[two] * 3) {
                    answer++;
                } else if (weights[one] * 2 == weights[two] * 4) {
                    answer++;
                } else if (weights[one] * 3 == weights[two] * 2) {
                    answer++;
                } else if (weights[one] * 3 == weights[two] * 4) {
                    answer++;
                } else if (weights[one] * 4 == weights[two] * 2) {
                    answer++;
                } else if (weights[one] * 4 == weights[two] * 3) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
