package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution("AAAAE") == 6);
        System.out.println(ts.solution("AAAE") == 10);
        System.out.println(ts.solution("I") == 1563);
        System.out.println(ts.solution("EIO") == 1189);
    }
}
