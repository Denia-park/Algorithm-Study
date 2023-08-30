package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.bestClosingTime("YYNY") == 2);
        System.out.println(solution.bestClosingTime("YYNY"));
//        System.out.println(solution.bestClosingTime("NNNNN") == 0);
        System.out.println(solution.bestClosingTime("NNNNN"));
//        System.out.println(solution.bestClosingTime("YYYY") == 4);
        System.out.println(solution.bestClosingTime("YYYY"));
    }
}

class Solution {
    public int bestClosingTime(String customers) {
        int closingTime = 0;
        int maxScore = 0;
        int curScore = 0;

        //처음부터 닫는 시간을 한시간씩 미루면서 최대 값을 찾는다.
        for (int timeIdx = 1; timeIdx <= customers.length(); timeIdx++) {
            if (customers.charAt(timeIdx - 1) == 'Y') {
                curScore++;
            } else {
                curScore--;
            }

            if (maxScore < curScore) {
                maxScore = curScore;
                closingTime = timeIdx;
            }
        }

        return closingTime;

    }
}
