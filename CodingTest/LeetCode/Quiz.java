package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.longestCommonSubsequence(
                "abcde",
                "ace"
        ));

        System.out.println("2 : " + solution.longestCommonSubsequence(
                "abc",
                "abc"
        ));

        System.out.println("3 : " + solution.longestCommonSubsequence(
                "abc",
                "def"
        ));

        System.out.println("4 : " + solution.longestCommonSubsequence(
                "bab",
                "ab"
        ));

        System.out.println("4 : " + solution.longestCommonSubsequence(
                "bca",
                "abc"
        ));
    }
}

class Solution {
    public int longestCommonSubsequence(final String text1, final String text2) {
        //input strings length
        final int len1 = text1.length();
        final char[] chars1 = text1.toCharArray();
        final int len2 = text2.length();
        final char[] chars2 = text2.toCharArray();

        //Create a 2D array to store the lengths of longes common subsequences
        //for all subproblems, initialized with zero
        final int[][] dp = new int[len1 + 1][len2 + 1];

        //Build dp array from bottom up
        for (int idx1 = 1; idx1 <= len1; idx1++) {
            for (int idx2 = 1; idx2 <= len2; idx2++) {
                //if char matches, take diagonal value and add 1
                if (chars1[idx1 - 1] == chars2[idx2 - 1]) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1;
                }
                // If characters do not match, take the maximum value from
                // above (dp[i-1][j]) or left (dp[i][j-1])
                else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }
            }
        }

        //The bottom-right cell contains the length of the longest
        return dp[len1][len2];
    }
}
