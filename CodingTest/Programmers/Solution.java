package CodingTest.Programmers;

class Solution {
    public int solution(String s) {
        int answer = 0;

        char firstCh = '0';
        int firstChNum = 0;
        int otherChNum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (firstCh == '0') {
                firstCh = s.charAt(i);
                firstChNum++;
                continue;
            }

            if (firstCh == s.charAt(i)) {
                firstChNum++;
            } else {
                otherChNum++;
            }

            if (firstChNum == otherChNum) {
                answer++;
                firstCh = '0';
                firstChNum = 0;
                otherChNum = 0;
            }
        }

        if (firstChNum != 0) {
            answer++;
        }

        return answer;
    }
}
