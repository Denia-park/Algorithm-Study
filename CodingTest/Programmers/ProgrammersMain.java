package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                "[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]"
        ))));
        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                "[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]"
        ))));
    }
}
