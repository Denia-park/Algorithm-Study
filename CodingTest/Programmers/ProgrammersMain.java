package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(ts.solution(100, 100, new int[]{10}));
        System.out.println(ts.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
