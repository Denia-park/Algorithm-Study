package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        ));
        System.out.println(ts.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}
        ));

    }
}



