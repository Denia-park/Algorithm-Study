package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(
                Arrays.toString(
                        ts.solution(
                                new String[][]{
                                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
                        )
                )
        );
//        System.out.println(Arrays.toString(ts.solution(5)));
//        System.out.println(Arrays.toString(ts.solution(6)));
//        System.out.println(Arrays.equals(ts.solution(6), new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}));
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

