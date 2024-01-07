package CodingTest.Programmers;

class Solution {
    public int solution(final int[] numbers) {
        int answer = 0;

        final int[] arr = new int[10];

        for (final int number : numbers) {
            arr[number]++;
        }

        for (int i = 0; i < arr.length; i++) {
            final int val = arr[i];

            if (val == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
