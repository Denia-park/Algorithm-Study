class Solution {
    int zeroCount;
    int oneCount;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        zeroCount = 0;
        oneCount = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt == 0)
                    zeroCount++;
                else
                    oneCount++;
            }
        }

        checkAllElements(arr, new int[]{0, 0}, arr.length);

        answer[0] += zeroCount;
        answer[1] += oneCount;

        return answer;
    }

    private void checkAllElements(int[][] arr, int[] start ,int length) {
        if (length == 1)
            return;

        boolean flag = true;

        int startValue = arr[start[0]][start[1]];

        out:
        for (int row = start[0]; row < start[0] + length; row++) {
            for (int col = start[1]; col < start[1] + length; col++) {
                if (startValue != arr[row][col]) {
                    flag = false;
                    break out;
                }
            }
        }

        if (flag) {
            int tempValue = (int) Math.pow(length, 2) - 1;

            if (startValue == 0)
                zeroCount -= tempValue;
            else
                oneCount -= tempValue;

            return;
        }


        checkAllElements(arr, start, length / 2);
        checkAllElements(arr, new int[]{start[0], start[1] + length / 2}, length / 2);
        checkAllElements(arr, new int[]{start[0] + length / 2, start[1]}, length / 2);
        checkAllElements(arr, new int[]{start[0] + length / 2, start[1] + length / 2}, length / 2);
    }
}
