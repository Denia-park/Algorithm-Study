package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println((ts.solution(
                        4,
                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                                "[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]"
                        )
                ))
        );

    }
}



