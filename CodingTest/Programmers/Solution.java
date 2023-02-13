package CodingTest.Programmers;

class Solution {
    public int solution(String main, String sub) {
        int answer = 0;
        long subVal = Long.parseLong(sub);

        for (int i = 0; i < main.length() - sub.length() + 1; i++) {
            long mainVal = Long.parseLong(main.substring(i, i + sub.length()));

            if (mainVal <= subVal) {
                answer++;
            }
        }

        return answer;
    }
}
