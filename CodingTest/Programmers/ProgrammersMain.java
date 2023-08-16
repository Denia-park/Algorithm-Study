package CodingTest.Programmers;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

//        int[][] routes = Util.convertStringToJavaIntTwoDimensionalArray(
//                "[[-20,-15],[-14,-5],[-18,-13],[-5,-3]]"
//        );

        System.out.println(ts.solution(new int[]{2}, new int[]{1}) == 0);
        System.out.println(ts.solution(new int[]{1}, new int[]{1}) == 0);
        System.out.println(ts.solution(new int[]{1}, new int[]{2}) == 1);
        System.out.println(ts.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}) == 3);
        System.out.println(ts.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}) == 0);
        System.out.println(ts.solution(new int[]{2, 2, 2, 2}, new int[]{2, 2, 2, 2}) == 0);
        System.out.println(ts.solution(new int[]{2, 2, 2, 2}, new int[]{3, 3, 2, 2}) == 2);
        System.out.println(ts.solution(new int[]{1, 2, 2, 2}, new int[]{3, 3, 2, 1}) == 3);
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

