package CodingTest.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] myArray = new int[100];
        for (Integer integer : arr) {
            myArray[integer] += 1;
        }

        return Arrays.stream(myArray).boxed().collect(Collectors.toList());
    }
}
