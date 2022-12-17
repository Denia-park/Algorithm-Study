import java.util.Arrays;

class Solution {
    long answer;
    int gNeedNum;

    public long solution(int lineNum, int needNum, int[] lineNums) {
        answer = 0;
        gNeedNum = needNum;

        Arrays.sort(lineNums);

        long start = 1;
        long end = lineNums[lineNum - 1];

        while (start <= end) {
            long mid = (start + end) / 2;

            if (calculateCount(lineNums, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean calculateCount(int[] lineNums, long mid) {
        long tempCount = 0;

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
