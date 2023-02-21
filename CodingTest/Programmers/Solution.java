package CodingTest.Programmers;

//JadenCase 문자열 만들기
//모든 단어의 첫 문자가 대문자
//나머지는 소문자

//알파벳, 숫자, 공백 으로 이루어짐
//숫자는 단어의 첫문자로만 나옴
//숫자로만 이루어진 단어 X
//공백문자 연속
class Solution {
    public String solution(String s) {
        boolean firstCharFlag = true;
        StringBuilder answer = new StringBuilder();

        char saveChar = '-';

        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);

            if (firstCharFlag) {
                answer.append(Character.toUpperCase(ch));
                firstCharFlag = false;
            } else {
                answer.append(Character.toLowerCase(ch));
            }

            if (ch == ' ') {
                firstCharFlag = saveChar != ' ';
            }
            saveChar = ch;
        }

        return answer.toString();
    }
}
