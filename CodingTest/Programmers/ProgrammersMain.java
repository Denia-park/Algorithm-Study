package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(0, 5, 30, 0, 7, 0));
        System.out.println(ts.solution(12, 0, 0, 12, 0, 30));
        System.out.println(ts.solution(0, 6, 1, 0, 6, 6));
        System.out.println(ts.solution(11, 59, 30, 12, 0, 0));
        System.out.println(ts.solution(11, 58, 59, 11, 59, 0));
        System.out.println(ts.solution(1, 5, 5, 1, 5, 6));
        System.out.println(ts.solution(0, 0, 0, 23, 59, 59));
    }
}


// 12345

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }

