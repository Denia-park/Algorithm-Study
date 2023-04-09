package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);

        return Math.max(numbers[0] * numbers[1], numbers[numbers.length - 2] * numbers[numbers.length - 1]);
    }
}
