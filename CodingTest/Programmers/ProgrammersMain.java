package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                BracketUtil.convertStringToJavaIntTwoDimensionalArray(
                        "[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]"
                )
        ));
    }
}



