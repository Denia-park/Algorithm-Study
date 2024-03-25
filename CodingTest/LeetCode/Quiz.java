package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.findDuplicates(
                        new int[]{4, 3, 2, 7, 8, 2, 3, 1}
                )
        );

        System.out.println(
                solution.findDuplicates(
                        new int[]{1, 1, 2}
                )
        );

        System.out.println(
                solution.findDuplicates(
                        new int[]{1}
                )
        );
    }
}

class Solution {
    public List<Integer> findDuplicates(final int[] nums) {
        final Set<Integer> set = new HashSet<>();

        final List<Integer> result = new ArrayList<>();
        for (final int num : nums) {
            if (set.contains(num)) {
                result.add(num);
            } else {
                set.add(num);
            }
        }

        return result;
    }
}
