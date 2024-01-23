package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println((ts.solution(
                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                                "[[0, 3], [1, 9], [2, 6]]"
                        )
                ))
        );
    }
}
