package CodingTest.Programmers;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        for (int one = 0; one < weights.length; one++) {
            for (int two = one + 1; two < weights.length; two++) {
                int gcd = gcd(weights[one], weights[two]);

                if (weights[one] / gcd <= 4 && weights[two] / gcd <= 4) {
                    answer++;
                }
            }
        }

        return answer;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
