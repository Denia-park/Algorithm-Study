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
        System.out.println(Arrays.toString(
                ts.solution(
                        new String[]{"classic", "pop", "classic", "classic"}
                        , new int[]{800, 600, 150, 800}
                )
        ));
        System.out.println(Arrays.toString(
                ts.solution(
                        new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"}
                        , new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                )
        ));
        System.out.println(Arrays.toString(
                ts.solution(
                        new String[]{"classic", "pop", "classic", "classic", "jazz", "pop", "Rock", "jazz"}
                        , new int[]{500, 600, 150, 800, 1100, 2500, 100, 1000}
                )
        ));
    }
}







