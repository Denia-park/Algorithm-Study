package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right").equals("LRLLLRLLRRL"));
        System.out.println(ts.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left").equals("LRLLRRLLLRR"));
        System.out.println(ts.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right").equals("LLRLLRLLRL"));

    }
}



