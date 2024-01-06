package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                "[[1, 4], [9, 2], [3, 8], [11, 6]]"
        )));
        System.out.println(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                "[[3, 5], [4, 1], [2, 4], [5, 10]]"
        )));
    }
}
