package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(ts.solution(new int[]{1, 2, 3, 4, 3, 2})));
    }
}
