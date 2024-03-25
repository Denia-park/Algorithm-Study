package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println((
                ts.solution(
                        3, 3,
                        BracketUtil.convertStrToIntArr(
                                "[[0, 0, 0], [0, 0, 0], [0, 0, 0]]"
                        )
                )
        ));
        System.out.println((
                ts.solution(
                        3, 6,
                        BracketUtil.convertStrToIntArr(
                                "[[0, 2, 0, 0, 0, 2], [0, 0, 2, 0, 1, 0], [1, 0, 0, 2, 2, 0]]"
                        )
                )
        ));
    }
}







