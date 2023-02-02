package CodingTest.Programmers;

class Solution {
    String[] babyBabbling = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;


        for (String str : babbling) {
            String newStr = str;
            for (String babble : babyBabbling) {
                newStr = newStr.replace(babble, "");
            }

            if (newStr.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}
