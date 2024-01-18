package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                        5,
                        BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]")
                )
        );
    }
}
