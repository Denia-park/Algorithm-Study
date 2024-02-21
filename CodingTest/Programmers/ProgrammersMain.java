package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[2, 3], [4, 3], [1, 1], [2, 1]]"
                )
        )));
        System.out.println(Arrays.toString(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], [7, 11], [4, 8], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]"
                )
        )));
    }
}



