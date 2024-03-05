package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minimumLength("ca"));
        System.out.println(solution.minimumLength("cabaabac"));
        System.out.println(solution.minimumLength("aabccabba"));
        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}

class Solution {
    public int minimumLength(final String s) {
        final char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;

        String str = s;
        while (!str.isEmpty() && start < end) {
//            System.out.println(str);

            int tempS = start;

            while (tempS < s.length() && chars[tempS] == chars[start]) {
                tempS++;
            }

            int tempE = end;
            while (tempS <= tempE && chars[tempE] == chars[end]) {
                tempE--;
            }

//            System.out.println(start + " : " + end);

            if (chars[start] == chars[end]) {
                str = s.substring(tempS, tempE + 1);
                start = tempS;
                end = tempE;
                continue;
            }

            break;
        }

        return str.length();
    }
}
