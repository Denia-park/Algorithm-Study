package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        System.out.println(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}

class Solution {
    public int[] intersection(final int[] nums1, final int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx1 = 0;
        int idx2 = 0;
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        final int[] arr = new int[1000];

        int count = 0;
        while (idx1 < len1 && idx2 < len2) {
            final int val1 = nums1[idx1];
            final int val2 = nums2[idx2];

            if (val1 == val2) {
                if (arr[val1] == 0) {
                    arr[val1]++;
                    count++;
                }

                idx1++;
                idx2++;
            } else if (val1 < val2) {
                idx1++;
            } else {
                idx2++;
            }
        }

        final int[] temp = new int[count];
        int countIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            final int val = arr[i];
            if (val == 0) {
                continue;
            }

            temp[countIdx++] = i;
        }

        return temp;
    }
}
