import java.util.Arrays;

class Solution {
    int answer;
    int gNeedNum;

    public int solution(int lineNum, int needNum, int[] lineNums) {
        answer = 0;
        gNeedNum = needNum;

        Arrays.sort(lineNums);

        int start = 0;
        int end = lineNums[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            if (calculateCount(lineNums, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean calculateCount(int[] lineNums, int mid) {
        int tempCount = 0;

        for (int lineNum : lineNums) {
            tempCount += lineNum / mid;
        }

        if (tempCount >= gNeedNum) {
            answer = Math.max(answer, mid);
            return true;
        }

        return false;
    }
}
