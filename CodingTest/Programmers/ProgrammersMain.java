package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]"))));
        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[0, 1, -1], [1, 0, -1], [1, 0, 1]]"))));
        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1, -1, 0], [2, -1, 0]]"))));
        System.out.println(Arrays.toString(ts.solution(BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1, -1, 0], [2, -1, 0], [4, -1, 0]]"))));
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

