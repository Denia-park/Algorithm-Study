package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

//        int[][] routes = Util.convertStringToJavaIntTwoDimensionalArray(
//                "[[1, 2], [2, 3]]"
//        );

        int[][] routes = new int[][]{{1, 2}, {2, 3}};

        System.out.println(Arrays.toString(ts.solution(5, routes, new int[]{2, 3}, 1)));

//        int[][] routes2 = Util.convertStringToJavaIntTwoDimensionalArray(
//                "[[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]"
//        );
        int[][] routes2 = new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        System.out.println(Arrays.toString(ts.solution(5, routes2, new int[]{1, 3, 5}, 5)));
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

