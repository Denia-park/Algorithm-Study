package CodingTest.Programmers;

class Solution {
    String[] babyBabbling = {"aya", "ye", "woo", "ma"};
    String[] noBabbling = {"ayaaya", "yeye", "woowoo", "mama"};

    public int solution(String[] babbling) {
        int answer = 0;


        out:
        for (String str : babbling) {
            String newStr = str;
            for (String babble : noBabbling) {
                if (newStr.contains(babble)) {
                    continue out;
                }
            }

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
