package CodingTest.Programmers;

class Solution {
    int[] multiple = {2, 3, 4};

    public long solution(int[] weights) {
        long answer = 0;

        for (int one = 0; one < weights.length; one++) {
            out:
            for (int two = one + 1; two < weights.length; two++) {
                if (weights[one] == weights[two]) {
                    answer++;
                    continue;
                }

                for (int i : multiple) {
                    for (int j : multiple) {
                        if (weights[one] * i == weights[two] * j) {
                            answer++;
                            continue out;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
