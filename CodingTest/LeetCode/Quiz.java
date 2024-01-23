package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.maxLength(
                List.of("un", "iq", "ue")
        ));
        System.out.println("2 : " + solution.maxLength(
                List.of("cha", "r", "act", "ers")
        ));
    }
}

/*
아이디어
- Bit Operation

시간복잡도
- O(N * M), where N is the number of strings in the array and M is the maximum length of a string in the array.

자료구조
-

 */

class Solution {
    static final int EMPTY_STRING = 0;

    public int maxLength(final List<String> arr) {
        final List<Integer> dp = new ArrayList<>();
        dp.add(EMPTY_STRING);

        int result = 0;

        for (final String s : arr) {
            int a = 0;
            int dup = 0;

            for (final char c : s.toCharArray()) {
                final int bitValue = 1 << (c - 'a');
                dup |= a & bitValue;
                a |= bitValue;
            }

            if (dup > 0) continue;

            for (int i = dp.size() - 1; i >= 0; i--) {
                final int dpVal = dp.get(i);

                if ((dpVal & a) > 0) continue;

                dp.add(dpVal | a);

                result = Math.max(result, Integer.bitCount(dpVal | a));
            }
        }

        return result;
    }
}
