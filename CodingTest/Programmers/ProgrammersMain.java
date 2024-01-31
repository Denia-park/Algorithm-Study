package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
        ));
        System.out.println(ts.solution(
                new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
        ));
        System.out.println(ts.solution(
                new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}
        ));

    }
}



