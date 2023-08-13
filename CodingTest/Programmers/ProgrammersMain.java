package CodingTest.Programmers;

import java.util.Arrays;

public class ProgrammersMain {
    public static void main(String[] args) {
        Solution ts = new Solution();

//        int[][] routes = Util.convertStringToJavaIntTwoDimensionalArray(
//                "[[-20,-15],[-14,-5],[-18,-13],[-5,-3]]"
//        );

        System.out.println(
                Arrays.equals(
                        ts.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}),
                        new String[]{"ICN", "JFK", "HND", "IAD"})
        );

        System.out.println(
                Arrays.equals(
                        ts.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}),
                        new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"})
        );

        System.out.println(
                Arrays.equals(
                        ts.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}),
                        new String[]{"ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"})
        );

        System.out.println(
                Arrays.equals(
                        ts.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}}),
                        new String[]{"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"})
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

