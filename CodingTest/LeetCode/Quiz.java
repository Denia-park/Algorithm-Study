package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.totalMoney(4));
        System.out.println(solution.totalMoney(10));
        System.out.println(solution.totalMoney(20));
    }
}

class Solution {
    public int totalMoney(final int n) {
        int startMoney = 0;
        int dayMoney = 0;
        int total = 0;

        int day = 1;
        while (day <= n) {
            if (day % 7 == 1) {
                startMoney++;
                dayMoney = startMoney;
            } else {
                dayMoney++;
            }

            total += dayMoney;
            day++;
        }

        return total;
    }
}
