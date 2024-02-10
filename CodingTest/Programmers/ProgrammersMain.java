package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(
                5,
                new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        )));
        System.out.println(Arrays.toString(ts.solution(
                1,
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        )));
        System.out.println(Arrays.toString(ts.solution(
                9,
                new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}
        )));
        System.out.println(Arrays.toString(ts.solution(
                10,
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}
        )));
    }
}



