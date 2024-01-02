package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(solution.findMatrix(new int[]{1, 2, 3, 4}));
    }
}

class Solution {
    public List<List<Integer>> findMatrix(final int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (final int num : nums) {
            final int count = map.getOrDefault(num, 0) + 1;
            maxCount = Math.max(maxCount, count);
            map.put(num, count);
        }

        final List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            answer.add(new ArrayList<>());
        }

        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            final int num = entry.getKey();
            final int count = entry.getValue();

            for (int idx = 0; idx < count; idx++) {
                answer.get(idx).add(num);
            }
        }

        return answer;
    }
}
