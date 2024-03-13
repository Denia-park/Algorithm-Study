package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(
                ts.solution(
                        new String[]{"classic", "pop", "classic", "classic", "pop"}
                        , new int[]{500, 600, 150, 800, 2500}
                )
        ));
    }
}







