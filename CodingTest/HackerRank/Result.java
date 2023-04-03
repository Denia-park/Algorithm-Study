package CodingTest.HackerRank;

import java.util.List;
import java.util.Optional;

public class Result {
    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        Optional<Integer> val = ar.stream().reduce(Integer::sum);
        return val.orElse(0);
    }
}
