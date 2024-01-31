package CodingTest.Programmers;

class Solution {
    public int solution(final int[] num_list) {
        String oddNums = "";
        String evenNums = "";

        for (final int i : num_list) {
            if (i % 2 == 1) {
                oddNums += i;
            } else {
                evenNums += i;
            }
        }

        return Integer.parseInt(oddNums) + Integer.parseInt(evenNums);
    }
}
