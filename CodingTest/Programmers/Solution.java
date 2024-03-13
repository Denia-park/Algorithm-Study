package CodingTest.Programmers;

class Solution {
    public int solution(final String num_str) {
        return num_str.chars()
                .map(ch -> ch - '0')
                .sum();
    }
}
