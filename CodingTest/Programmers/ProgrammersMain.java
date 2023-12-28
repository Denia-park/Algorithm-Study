package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution("100-200*300-500+20") == 60420);
        System.out.println(ts.solution("50*6-3*2") == 300);
    }
}
