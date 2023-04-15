package CodingTest.Programmers;

//정답 참고
//https://velog.io/@sa833591/%EA%B0%80%EC%9E%A5-%EA%B8%B4-%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.3

//완전탐색 2중 for문으로는 풀었지만 도저히 시간을 줄이지 못해서 정답을 참고함
//정답을 보니 좀 신기하면서 대단하다.

class Solution {
    public int solution(String s) {
        int answer = 1;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            //odd
            answer = Math.max(answer, isPalindrome(s, i, i));
            //even
            answer = Math.max(answer, isPalindrome(s, i, i + 1));
        }

        return answer;
    }

    private int isPalindrome(String str, int left, int right) {
        int len = str.length();

        while (0 <= left && right < len && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
