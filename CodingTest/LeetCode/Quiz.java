package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.closeStrings("abc", "bca"));
        System.out.println("2 : " + solution.closeStrings("a", "aa"));
        System.out.println("3 : " + solution.closeStrings("cabbba", "abbccc"));
    }
}

class Solution {
    public boolean closeStrings(final String word1, final String word2) {
        //길이가 다르면 false
        final int len1 = word1.length();
        final int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }

        //사용된 글자의 종류가 다르면 false
        final int[] word1CharCount = new int[26];
        final char[] chars1 = word1.toCharArray();
        for (int i = 0; i < len1; i++) {
            word1CharCount[chars1[i] - 'a']++;
        }
        final int[] word2CharCount = new int[26];
        final char[] chars2 = word2.toCharArray();
        for (int i = 0; i < len2; i++) {
            word2CharCount[chars2[i] - 'a']++;
        }

        final int chatCountLength = word1CharCount.length;
        for (int i = 0; i < chatCountLength; i++) {
            if (word1CharCount[i] == 0 && word2CharCount[i] != 0
                    || word1CharCount[i] != 0 && word2CharCount[i] == 0) {
                return false;
            }
        }

        //사용된 글자들의 사용 개수 패턴이 다르면 false
        Arrays.sort(word1CharCount);
        Arrays.sort(word2CharCount);

        for (int i = 0; i < chatCountLength; i++) {
            if (word1CharCount[i] != word2CharCount[i]) {
                return false;
            }
        }

        return true;
    }
}
