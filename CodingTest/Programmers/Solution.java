package CodingTest.Programmers;

class Solution {
    public int solution(final String num_str) {
        int answer = 0;
        final int len = num_str.length();

        for (int i = 0; i < len; i++) {
            answer += num_str.charAt(i) - '0';
        }

        return answer;
    }
}
