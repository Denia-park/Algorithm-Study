package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

//        System.out.println((ts.solution(
//                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
//                                "[[0, 3], [1, 9], [2, 6]]"
//                        )
//                ))
//        );
        System.out.println((ts.solution(
                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                                "[[24, 10], [28, 39], [43, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]"
                        )
                ))
        );
//        System.out.println((ts.solution(
//                        BracketUtil.convertStringToJavaIntTwoDimensionalArray(
//                                "[[0, 1], [1, 1], [50, 7]]"
//                        )
//                ))
//        );
    }
}
