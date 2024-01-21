package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.deepToString(ts.solution(
                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                                "[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]"
                        )
                ))
        );
    }
}
