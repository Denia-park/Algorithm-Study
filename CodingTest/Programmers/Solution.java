package CodingTest.Programmers;

class Solution {
    public int solution(int[] numbers, int k) {
        int answerIdx = 0;

        int count = 0;

        while (count < (k - 1)) {
            answerIdx = (answerIdx + 2) % numbers.length;
            count++;
        }

        return answerIdx + 1;
    }
}
