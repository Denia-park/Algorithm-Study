package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println("2 : " + solution.minOperations(new int[]{2, 1, 2, 2, 3, 3}));
        System.out.println("3 : " + solution.minOperations(new int[]{19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19}));
    }
}

class Solution {
    public int minOperations(final int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();

        //모든 숫자들을 Map으로 센다.
        for (final int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (final Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int value = entry.getValue();

            while (value != 0) {
                //2의 배수, 3의 배수 순으로 먼저 처리한다.
                if (value % 3 == 0) {
                    count += (value / 3);
                    value = 0;
                } else if (value % 5 == 3 || value % 5 == 0) {
                    value -= 5;
                    count += 2;
                } else if (value % 7 == 3 || value % 7 == 0) {
                    value -= 7;
                    count += 3;
                } else if (value % 2 == 0) {
                    count += (value / 2);
                    value = 0;
                } else {
                    return -1;
                }
            }
        }

        return count;
    }
}
