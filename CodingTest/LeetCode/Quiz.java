package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYNY") == 2);
        System.out.println(solution.bestClosingTime("NNNNN") == 0);
        System.out.println(solution.bestClosingTime("YYYY") == 4);
    }
}

class Solution {
    //닫는 시간에 따라 계산 값이 다르다.
    //닫기 전에는 Y 로,닫는 순간부터는 쭉 N 으로 친다.
    //O(N) 방법으로 탐색하는 방법이 있을 것 같다.
    public int bestClosingTime(String customers) {
        //처음에 한바퀴 돌면서 총 Y가 몇개인지 세어본다
        int count = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                count++;
            }
        }

        //0번째시간에 문을 닫는다면, 총 Y의 개수가 전체 패널티이다.
        //0번째 인덱스를 생각하기 보다는, 0번째 인덱스 앞이 0번째때 문 닫는 시간이라고 생각하면 편하다. (아래와 같이)
        // 0 1 2 3 4
        //  Y Y N Y
        int closingTime = 0;
        int minPenalty = count;
        int penalty = count;

        //처음부터 닫는 시간을 한시간씩 미루면서 최소 값을 찾는다.
        for (int timeIdx = 1; timeIdx <= customers.length(); timeIdx++) {
            if (customers.charAt(timeIdx - 1) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (minPenalty > penalty) {
                minPenalty = penalty;
                closingTime = timeIdx;
            }
        }

        return closingTime;

    }
}
