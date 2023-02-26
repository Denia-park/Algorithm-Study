package CodingTest.Programmers;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < emergency.length; i++) {
            int key = emergency[i];
            map.put(key, i);
        }

        int[] answer = new int[emergency.length];
        int idx = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer[entry.getValue()] = idx;
            idx++;
        }

        return answer;
    }
}
