package CodingTest.Programmers;

class Solution {
    public String solution(final String s, final int n) {
        final StringBuilder stringBuilder = new StringBuilder();

        final int LowerZ = 'z';
        final int UpperZ = 'Z';

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);

            if (Character.isLowerCase(c)) {
                int newChar = c + n;
                if (newChar > LowerZ) {
                    newChar = newChar - LowerZ + 'a' - 1;
                }

                stringBuilder.append((char) newChar);
            } else if (Character.isUpperCase(c)) {
                int newChar = c + n;

                if (newChar > UpperZ) {
                    newChar = newChar - UpperZ + 'A' - 1;
                }

                stringBuilder.append((char) newChar);
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
