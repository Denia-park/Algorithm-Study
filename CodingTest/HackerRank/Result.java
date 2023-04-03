package CodingTest.HackerRank;

import java.util.List;

public class Result {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int ans;
        int size = arr.get(0).size();

        //11 -> 5  대각선
        int sum1 = 0;
        for (int i = 0; i < size; i++) {
            sum1 += arr.get(i).get(i);
        }
        //1 -> 7  대각선
        int sum2 = 0;
        for (int i = 0; i < size; i++) {
            sum2 += arr.get(i).get(size - 1 - i);
        }

        return Math.abs(sum1 - sum2);
    }
}
