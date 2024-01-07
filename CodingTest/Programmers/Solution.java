package CodingTest.Programmers;

class Solution {
    public int solution(final String before, final String after) {
        final int[] beforeAlphabetCount = new int[26];
        final int[] afterAlphabetCount = new int[26];

        for (int i = 0; i < before.length(); i++) {
            beforeAlphabetCount[before.charAt(i) - 'a']++;
            afterAlphabetCount[after.charAt(i) - 'a']++;
        }

        for (int i = 0; i < beforeAlphabetCount.length; i++) {
            if (beforeAlphabetCount[i] != afterAlphabetCount[i]) {
                return 0;
            }
        }

        return 1;
    }
}
