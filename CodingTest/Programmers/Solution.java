package CodingTest.Programmers;

import java.util.stream.Collectors;

class Solution {
    public String solution(final String my_string) {
        return my_string.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
