package CodingTest.Programmers;

class Solution {
    public String solution(final String s) {
        String answer = "";

        int numCount = 1;

        for (int idx = 0; idx < s.length(); idx++) {
            final char ch = s.charAt(idx);

            if (ch == ' ') {
                answer += " ";
                numCount = 1;
                continue;
            }

            if (numCount % 2 == 1) {
                answer += Character.toUpperCase(ch);
            } else {
                answer += Character.toLowerCase(ch);
            }
            numCount++;
        }

        return answer;
    }
}
