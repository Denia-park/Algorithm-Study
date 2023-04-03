package CodingTest.HackerRank;

import java.util.List;

public class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int size = matrix.size();

        int sum = 0;

        for (int r = 0; r < size / 2; r++) {
            for (int c = 0; c < size / 2; c++) {
                int maxVal1 = Math.max(matrix.get(r).get(c), matrix.get(r).get(size - 1 - c));
                int maxVal2 = Math.max(matrix.get(size - 1 - r).get(c), matrix.get(size - 1 - r).get(size - 1 - c));

                sum += Math.max(maxVal1, maxVal2);
            }
        }
        
        return sum;
    }
}
