package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution("one4seveneight") == 1478);
        System.out.println(ts.solution("23four5six7") == 234567);
        System.out.println(ts.solution("2three45sixseven") == 234567);
        System.out.println(ts.solution("123") == 123);
    }
}
