package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

        int[][] val1 = Util.convertStringToJavaIntTwoDimensionalArray("[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]");
        System.out.println(ts.solution(6, 4, 6, 2, val1));

        int[][] val2 = Util.convertStringToJavaIntTwoDimensionalArray("[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]");
        System.out.println(ts.solution(7, 3, 4, 1, val2));

        int[][] val3 = Util.convertStringToJavaIntTwoDimensionalArray("[[2, 6, 6], [6, 3, 7], [4, 6, 7], [6, 5, 11], [2, 5, 12], [5, 3, 20], [2, 4, 8], [4, 3, 9]]");
        System.out.println(ts.solution(6, 4, 5, 6, val3));
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

