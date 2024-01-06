package CodingTest.Programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(final String my_string) {
        final StringBuilder sb = new StringBuilder();
        final Set<Character> set = new HashSet<>();

        for (int i = 0; i < my_string.length(); i++) {
            final char ch = my_string.charAt(i);

            if (set.contains(ch)) {
                continue;
            }

            set.add(ch);
            sb.append(ch);
        }

        return sb.toString();
    }
}
