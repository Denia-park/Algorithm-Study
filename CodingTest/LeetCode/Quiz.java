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
        if (word1.length() != word2.length()) {
            return false;
        }

        //사용된 글자의 종류가 다르면 false
        final int[] word1CharCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1CharCount[word1.charAt(i) - 'a']++;
        }
        final int[] word2CharCount = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            word2CharCount[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2CharCount.length; i++) {
            if (word1CharCount[i] == 0 && word2CharCount[i] != 0
                    || word1CharCount[i] != 0 && word2CharCount[i] == 0) {
                return false;
            }
        }

        //사용된 글자들의 사용 개수 패턴이 다르면 false
        Arrays.sort(word1CharCount);
        Arrays.sort(word2CharCount);

        for (int i = 0; i < word2CharCount.length; i++) {
            if (word1CharCount[i] != word2CharCount[i]) {
                return false;
            }
        }

        return true;
    }
}
