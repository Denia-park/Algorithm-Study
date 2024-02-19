package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[1, 1, 1], [1, 1, 1], [1, 1, 1]]"
                ),
                new int[]{1, 0},
                new int[]{1, 2}
        ));
        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[1, 1, 1], [1, 0, 1], [1, 1, 1]]"
                ),
                new int[]{1, 0},
                new int[]{1, 2}
        ));
        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[1, 1, 1, 1, 1]]"
                ),
                new int[]{0, 0},
                new int[]{0, 4}
        ));
        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[1]]"
                ),
                new int[]{0, 0},
                new int[]{0, 0}
        ));
    }
}



