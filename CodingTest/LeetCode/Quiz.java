package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("2 : " + solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println("3 : " + solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}

class Solution {
    public int lengthOfLIS(final int[] nums) {
        final List<Integer> answer = new ArrayList<>();

        for (final int value : nums) {
            //비어 있거나, 추가할 값이 list의 마지막 값보다 크다면 추가
            if (answer.isEmpty() || answer.get(answer.size() - 1) < value) {
                answer.add(value);
                continue;
            }

            //새로 추가해야하는 값을 적절한 위치에 삽입
            bisectLeft(answer, value);
        }

        return answer.size();
    }

    private void bisectLeft(final List<Integer> answer, final int targetValue) {
        int left = 0;
        int right = answer.size();

        while (left < right) {
            final int midIdx = left + (right - left) / 2;
            final int midValue = answer.get(midIdx);

            if (midValue < targetValue) {
                left = midIdx + 1;
            } else {
                right = midIdx;
            }
        }

        answer.set(right, targetValue);
    }
}
