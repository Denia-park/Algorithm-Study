package CodingTest.Programmers;

/*
replace를 사용해서 한개를 지우고 난 경우에
단어들이 합쳐지면서 다시 지울수 있는 단어가 생기는 경우가 있어서 예외처리가 필요함

ex) myea -> 'ye'지움
ma -> 'ma'지움
 */
class Solution {
    String[] babyBabbling = {"aya", "ye", "woo", "ma"};
    String[] noBabbling = {"ayaaya", "yeye", "woowoo", "mama"};

    public int solution(String[] babbling) {
        int answer = 0;


        out:
        for (String str : babbling) {
            String newStr = str;
            int idx = 0;
            for (String babble : babyBabbling) {
                newStr = newStr.replace(babble, "" + idx);
                idx++;
            }

            for (int i = 0; i < newStr.length() - 1; i++) {
                char ch = newStr.charAt(i);
                if (!Character.isDigit(ch) || ch == newStr.charAt(i + 1)) {
                    continue out;
                }
            }

            if (!Character.isDigit(newStr.charAt(newStr.length() - 1))) {
                continue out;
            }

            answer++;
        }
        return answer;
    }
}
