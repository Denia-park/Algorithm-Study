package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(
                        new String[]{"I 16", "I -5643", "D - 1", "D 1", "D 1", "I 123", "D - 1"}
                ))
        );
        System.out.println(Arrays.toString(ts.solution(
                        new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
                ))
        );


    }
}
