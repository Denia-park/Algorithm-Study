package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(final String[] args) {
        final Solution ts = new Solution();

        System.out.println(ts.solution(new int[]{5, 1, 5}, 30, BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[2, 10], [9, 15], [10, 5], [11, 5]]")));
        System.out.println(ts.solution(new int[]{3, 2, 7}, 20, BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1, 15], [5, 16], [8, 6]]")));
        System.out.println(ts.solution(new int[]{4, 2, 7}, 20, BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1, 15], [5, 16], [8, 6]]")));
        System.out.println(ts.solution(new int[]{1, 1, 1}, 5, BracketUtil.convertStringToJavaIntTwoDimensionalArray("[[1, 2], [3, 2]]")));
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

