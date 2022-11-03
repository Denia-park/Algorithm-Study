class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

        long myNum = begin;

        for (int idx = 0; idx <= (end - begin); idx++) {
            if (myNum == 1) {
                answer[idx] = 0;
            } else if (myNum % 2 == 0) {
                answer[idx] = (int) (myNum / 2);
            } else {
                int divideNum = getDivideNum(myNum);
                if (divideNum == -1) {
                    answer[idx] = 1;
                } else {
                    answer[idx] = (divideNum);
                }
            }

            myNum++;
        }

        return answer;
    }

    private int getDivideNum(long value) {
        int lastVal = -1;
        for (int i = 3; i <= Math.sqrt(value); i += 2) {
            if (value % i == 0) {
                lastVal = (int) (value / i);
                break;
            }
        }

        return lastVal;
    }
}
