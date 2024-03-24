package CodingTest.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.findDuplicate(
                        new int[]{1, 3, 4, 2, 2}
                )
        );

        System.out.println(
                solution.findDuplicate(
                        new int[]{3, 1, 3, 4, 2}
                )
        );

        System.out.println(
                solution.findDuplicate(
                        new int[]{3, 3, 3, 3, 3}
                )
        );
    }
}

class Solution {
    public int findDuplicate(final int[] nums) {
        final Set<Integer> set = new HashSet<>();

        for (final int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }
}
