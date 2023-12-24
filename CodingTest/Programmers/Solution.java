package CodingTest.Programmers;

class Solution {
    boolean solution(final String s) {
        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (Character.toUpperCase(ch) == 'P') {
                pCount++;
            } else if (Character.toUpperCase(ch) == 'Y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
