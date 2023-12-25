package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution("...!@BaT#*..y.abcdefghijklm").equals("bat.y.abcdefghi"));
        System.out.println(ts.solution("z-+.^.").equals("z--"));
        System.out.println(ts.solution("=.=").equals("aaa"));
        System.out.println(ts.solution("123_.def").equals("123_.def"));
        System.out.println(ts.solution("abcdefghijklmn.p").equals("abcdefghijklmn"));
    }
}
