package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }
}

class Solution {
    public int findSpecialInteger(final int[] arr) {
        final int length = arr.length;

        final double ratio = (double) length / 4;

        int saveValue = arr[0];
        int count = 0;
        for (int i = 0; i < length; i++) {
            final int val = arr[i];

            if (val == saveValue) {
                count++;

                if (count > ratio) {
                    return val;
                }
            } else {
                saveValue = val;
                count = 1;
            }
        }

        return arr[length - 1];
    }
}
