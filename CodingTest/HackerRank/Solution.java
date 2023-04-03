package CodingTest.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(112, 42, 83, 119));
        list.add(Arrays.asList(56, 125, 56, 49));
        list.add(Arrays.asList(15, 78, 101, 43));
        list.add(Arrays.asList(62, 98, 114, 108));

        Result.flippingMatrix(list);
    }
}
