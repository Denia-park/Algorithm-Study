package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(final int[] numbers) {
        final Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(comp)
                .reduce((s1, s2) -> s1 + s2)
                .filter(s -> !s.startsWith("0"))
                .orElse("0");
    }
}
