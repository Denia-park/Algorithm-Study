package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int element : array) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return map.getOrDefault(n, 0);
    }
}
