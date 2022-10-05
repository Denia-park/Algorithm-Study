class Solution {
    int zeroCount;
    int oneCount;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        zeroCount = 0;
        oneCount = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt == 0){
                    zeroCount++;
                }else{
                    oneCount++;
                }
            }
        }

        checkAllElements(arr, 0, arr.length);

        answer[0] += zeroCount;
        answer[1] += oneCount;

        return answer;
    }

    private void checkAllElements(int[][] arr, int start ,int end) {
        if(start == end){
            return;
        }

        boolean flag = true;
        int startValue = arr[start][start];

        out : for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if(startValue != arr[i][j]){
                    flag = false;
                    break out;
                }
            }
        }

        if(flag){
            int tempValue = (int) Math.pow((end - start + 1), 2);

            if(startValue == 0){
                zeroCount += tempValue;
            }else{
                oneCount += tempValue;
            }
        }

        checkAllElements(arr, start, end / 2);
        checkAllElements(arr, end / 2, end);
        checkAllElements(arr, start, end / 2);
        checkAllElements(arr, start, end / 2);
    }
}
