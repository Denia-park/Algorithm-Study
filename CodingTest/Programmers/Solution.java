package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] split = my_string.split(" ");

        return Arrays.stream(split).filter(str -> !str.isEmpty()).toArray(String[]::new);
    }
}
