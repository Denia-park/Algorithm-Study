class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] arrX = new int[10];
        int[] arrY = new int[10];

        countNumInArr(X, arrX);
        countNumInArr(Y, arrY);

        for (int i = arrX.length - 1; i >= 0; i--) {
            while (arrX[i] >= 1 && arrY[i] >= 1) {
                arrX[i]--;
                arrY[i]--;

                answer += i;
            }
        }

        if (answer.equals("")) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        } else {
            return answer;
        }
    }

    private void countNumInArr(String str, int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';

            arr[index]++;
        }
    }
}
