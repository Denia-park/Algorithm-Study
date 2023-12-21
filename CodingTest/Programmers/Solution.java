package CodingTest.Programmers;

class Solution {
    public int[][] solution(final int[][] arr1, final int[][] arr2) {
        final int newRowNum = arr1.length;
        final int newColNum = arr2[0].length;

        final int[][] answer = new int[newRowNum][newColNum];

        //행렬의 곱셈
        for (int row = 0; row < newRowNum; row++) {
            for (int col = 0; col < newColNum; col++) {
                int tempValue = 0;

                //arr1 col만큼, arr2 row만큼
                for (int idx = 0; idx < arr1[0].length; idx++) {
                    tempValue += arr1[row][idx] * arr2[idx][col];
                }

                answer[row][col] = tempValue;
            }
        }

        return answer;
    }
}
