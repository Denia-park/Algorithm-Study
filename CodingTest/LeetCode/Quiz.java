package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }
}

class Solution {
    public List<Boolean> checkArithmeticSubarrays(final int[] nums, final int[] l, final int[] r) {
        final List<Boolean> booleans = new ArrayList<>();
        final List<Integer> numsList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < l.length; i++) {
            final int leftStartInclude = l[i];
            final int rightEndInclude = r[i];

            final List<Integer> integers = subList(numsList, leftStartInclude, rightEndInclude);

            booleans.add(isArithmeticSequence(integers));
        }

        return booleans;
    }

    private List<Integer> subList(final List<Integer> numsList, final int leftStartInclude, final int rightEndExclude) {
        final List<Integer> returnList = new ArrayList<>();

        for (int i = leftStartInclude; i <= rightEndExclude; i++) {
            returnList.add(numsList.get(i));
        }

        return returnList;
    }

    private Boolean isArithmeticSequence(final List<Integer> integers) {
        integers.sort(null);
        final int sub = integers.get(1) - integers.get(0);

        for (int i = 2; i < integers.size(); i++) {
            if (integers.get(i) - integers.get(i - 1) != sub) {
                return false;
            }
        }

        return true;
    }
}
