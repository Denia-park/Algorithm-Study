package CodingTest.Programmers.HackerRank;

import java.util.List;

public class Result {
    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Write your code here

        arr.sort(null);

        int length = arr.size();
        int mid = length / 2;

        return arr.get(mid);
    }
}
