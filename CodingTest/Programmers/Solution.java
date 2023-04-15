package CodingTest.Programmers;

class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (answer > (j - i + 1)) continue;

                String subString = s.substring(i, j + 1);
                int subLen = subString.length();

                if (isPalindrome(subString)) {
                    answer = subLen;
                }
            }
        }

        return answer;
    }

    private boolean isPalindrome(String subString) {
        int len = subString.length();
        int limit;
        if (len % 2 == 0) {
            limit = len / 2 + 1;
        } else {
            limit = len / 2;
        }

        for (int i = 0; i < limit; i++) {
            if (subString.charAt(i) != subString.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
