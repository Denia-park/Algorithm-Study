package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]"
                ),
                BracketUtil.convertStrToIntArr(
                        "[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]"
                )
        ));

        System.out.println(ts.solution(
                BracketUtil.convertStrToIntArr(
                        "[[1,2,3],[4,5,6],[7,8,9]]"
                ),
                BracketUtil.convertStrToIntArr(
                        "[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]"
                )
        ));
    }
}



