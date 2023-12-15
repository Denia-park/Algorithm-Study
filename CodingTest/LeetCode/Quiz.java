package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        final List<List<String>> lists = List.of(List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));

        System.out.println(solution.destCity(lists));
    }
}

class Solution {
    public String destCity(final List<List<String>> paths) {
        final Map<String, String> map = new HashMap<>();

        for (final List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        for (final String value : map.values()) {
            if (!map.containsKey(value)) {
                return value;
            }
        }

        return "";
    }
}
