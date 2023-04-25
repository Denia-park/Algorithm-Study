package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);

        List<Integer> list = new ArrayList<>();
        for (int i = 5; i < num_list.length; i++) {
            list.add(num_list[i]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
