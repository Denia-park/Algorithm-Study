package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println((Arrays.toString(ts.solution(
                        new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                        new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}
                )))
        );

    }
}



