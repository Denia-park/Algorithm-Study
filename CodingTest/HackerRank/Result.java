package CodingTest.HackerRank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Result {
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Set<Integer> set = new HashSet<>();

        for (Integer i : a) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }

        Iterator<Integer> iterator = set.iterator();

        return iterator.hasNext() ? iterator.next() : 0;
    }
}
