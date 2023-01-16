package CodingTest.Programers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = -1;

            if (map.containsKey(c)) {
                val = (i - map.get(c));
            }

            map.put(c, i);
            answer[i] = val;
        }

        return answer;
    }
}
