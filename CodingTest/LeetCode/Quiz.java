package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println(solution.getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));
    }
}

class Solution {
    public int getCommon(final int[] nums1, final int[] nums2) {
        final int answer = -1;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            final int val1 = nums1[idx1];
            final int val2 = nums2[idx2];

            if (val1 == val2) {
                return val1;
            }

            if (val1 < val2) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return answer;
    }
}
