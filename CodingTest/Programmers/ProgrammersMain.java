package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution("110010101001")));
        System.out.println(Arrays.toString(ts.solution("01110")));
        System.out.println(Arrays.toString(ts.solution("1111111")));
    }
}
