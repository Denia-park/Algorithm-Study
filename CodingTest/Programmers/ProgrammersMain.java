package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                5,
                new int[]{2, 4},
                new int[]{1, 3, 5}
        ));
        System.out.println(ts.solution(
                5,
                new int[]{2, 4},
                new int[]{3}
        ));
        System.out.println(ts.solution(
                3,
                new int[]{3},
                new int[]{1}
        ));

    }
}



