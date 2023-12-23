package CodingTest.Programmers;

class Solution {
    public int solution(int n) {
        final StringBuilder tempStr = new StringBuilder();

        while (n > 0) {
            tempStr.append(n % 3);
            n /= 3;
        }

        return Integer.valueOf(tempStr.toString(), 3);
    }
}
