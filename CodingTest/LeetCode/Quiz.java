package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("ab", "a"));
        System.out.println(solution.checkInclusion("ky", "ainwkckifykxlribaypk"));
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) {
            return false;
        }

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (int i = 0; i < s1Len; i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }
        for (int start = 0; start < s1Len; start++) {
            s2Arr[s2.charAt(start) - 'a']++;
        }

        if (Arrays.equals(s1Arr, s2Arr)) {
            return true;
        }

        for (int end = s1Len, start = 0; end < s2Len; end++, start++) {
            s2Arr[s2.charAt(end) - 'a']++;
            s2Arr[s2.charAt(start) - 'a']--;

            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
        }

        return false;
    }
}
