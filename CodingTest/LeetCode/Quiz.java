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

        //10 순서 혹은 01 순서로 비교해서 값 비교하기
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    zeroOneCount++;
                } else {
                    oneZeroCount++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    zeroOneCount++;
                } else {
                    oneZeroCount++;
                }
            }
        }

        return Math.min(zeroOneCount, oneZeroCount);
    }
}
