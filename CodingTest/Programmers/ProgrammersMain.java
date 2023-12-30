package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
        System.out.println(Arrays.toString(ts.solution(new int[]{1, 5, 2, 60, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
        System.out.println(Arrays.toString(ts.solution(new int[]{6}, new int[][]{{1, 1, 1}})));
        System.out.println(Arrays.toString(ts.solution(new int[]{10, 2}, new int[][]{{1, 2, 1}})));
        System.out.println(Arrays.toString(ts.solution(new int[]{1, 2, 3, 4, 100, 1, 100, 3, 6, 3, 4, 5, 6, 5, 100}, new int[][]{{1, 11, 7}})));

    }
}
