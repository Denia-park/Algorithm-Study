package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println((Arrays.toString(ts.solution(
                        new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}
                )))
        );
        System.out.println((Arrays.toString(ts.solution(
                        new String[]{"AA", "AB", "AC", "AA", "AC"}
                )))
        );
        System.out.println((Arrays.toString(ts.solution(
                        new String[]{"XYZ", "XYZ", "XYZ"}
                )))
        );
        System.out.println((Arrays.toString(ts.solution(
                        new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
                )))
        );

    }
}



