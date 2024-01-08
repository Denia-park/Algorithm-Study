package CodingTest.Programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(final String[] participant, final String[] completion) {
        final Map<String, Integer> map = new HashMap<>();

        for (final String string : participant) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        for (final String string : completion) {
            final int count = map.get(string) - 1;

            if (count == 0) {
                map.remove(string);
                continue;
            }

            map.put(string, count);
        }

        return map.keySet().iterator().next();
    }
}
