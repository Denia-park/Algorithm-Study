package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(new Food("abc", "B", 1).equals(new Food("abc", "B", 2)));

        System.out.println(solution.minOperations("0100") == 1);
        System.out.println(solution.minOperations("10") == 0);
        System.out.println(solution.minOperations("1111") == 2);
        System.out.println(solution.minOperations("110") == 1);
        System.out.println(solution.minOperations("0011100") == 3);
    }
}

class Solution {
    public int minOperations(final String s) {
        int zeroOneCount = 0;
        int oneZeroCount = 0;

        //2개씩 잘라서 10 만들어서 값 가지기
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    zeroOneCount++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    zeroOneCount++;
                }
            }
        }

        //2개씩 잘라서 01 만들어서 값 가지기
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    oneZeroCount++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    oneZeroCount++;
                }
            }
        }

        return Math.min(zeroOneCount, oneZeroCount);
    }
}
