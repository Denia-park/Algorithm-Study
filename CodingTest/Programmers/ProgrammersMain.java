package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

//        int[][] routes = Util.convertStringToJavaIntTwoDimensionalArray(
//                "[[-20,-15],[-14,-5],[-18,-13],[-5,-3]]"
//        );

        System.out.println(
                ts.solution(new int[]{9, -1, -5}) == 3
        );
        System.out.println(
                ts.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}) == 6
        );
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

