package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }
}

class Solution {
    public int countSubstrings(final String s) {
        int answer = 0;
        final int length = s.length();

        for (int st = 0; st < length; st++) {
            int left = st;
            int right = st;

            //홀수개
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right)) {
                    answer++;
                }

                left--;
                right++;
            }

            //짝수개
            left = st;
            right = st + 1;

            //짝수개
            while (left >= 0 && right < length) {
                if (s.charAt(left) == s.charAt(right)) {
                    answer++;
                }

                left--;
                right++;
            }
        }

        return answer;
    }
}
