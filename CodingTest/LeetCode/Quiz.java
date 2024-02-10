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
            for (int en = st; en < length; en++) {
                final String sub = s.substring(st, en + 1);

                if (isPalindrome(sub)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPalindrome(final String sub) {
        final int len = sub.length();

        //팰린드롬 확인 -> 양쪽에서 중간으로 Idx를 바꿔가면서 비교하면 된다.
        for (int idx = 0; idx < len / 2; idx++) {
            final int st = idx;
            final int ed = len - 1 - idx;

            if (sub.charAt(st) != sub.charAt(ed)) {
                return false;
            }
        }

        return true;
    }
}
