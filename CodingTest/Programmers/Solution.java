package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        List<Long> list = new ArrayList<>();

        for (String str : arr) {
            list.add(Long.parseLong(str));
        }

        list.sort(null);

        long min = list.get(0);
        long max = list.get(list.size() - 1);

        return min + " " + max;
    }
}
