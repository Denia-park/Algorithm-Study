package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

        int[][] routes = Util.convertStringToJavaIntTwoDimensionalArray(
                "[[1, 1, 0], [1, 1, 0], [0, 0, 1]]"
        );

        System.out.println(ts.solution(3, routes));
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

