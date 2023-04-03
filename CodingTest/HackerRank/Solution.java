package CodingTest.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(11, 2, 4));
        list.add(Arrays.asList(4, 5, 6));
        list.add(Arrays.asList(10, 8, -12));
        Result.diagonalDifference(list);
    }
}
