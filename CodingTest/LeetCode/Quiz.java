package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(final int[] nums) {
        Arrays.sort(nums);
        final int length = nums.length;

        final int[] groupSize = new int[length];
        final int[] prevElement = new int[length];
        int maxIndex = 0;

        for (int end = 0; end < length; end++) {
            groupSize[end] = 1;
            prevElement[end] = -1;

            for (int loop = 0; loop < end; loop++) {
                if (nums[end] % nums[loop] == 0 && groupSize[end] < (1 + groupSize[loop])) {
                    groupSize[end] = 1 + groupSize[loop];
                    prevElement[end] = loop;

                }
            }

            if (groupSize[end] > groupSize[maxIndex]) {
                maxIndex = end;
            }
        }

        final List<Integer> result = new ArrayList();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prevElement[maxIndex];
        }

        return result;
    }
}
